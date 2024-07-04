package org.opengoofy.congomall.springboot.starter.idempotent.core.token;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.opengoofy.congomall.springboot.starter.cache.DistributedCache;
import org.opengoofy.congomall.springboot.starter.convention.errorcode.BaseErrorCode;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import org.opengoofy.congomall.springboot.starter.idempotent.config.IdempotentProperties;
import org.opengoofy.congomall.springboot.starter.idempotent.core.AbstractIdempotentTemplate;
import org.opengoofy.congomall.springboot.starter.idempotent.core.IdempotentParamWrapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

/**
 * 基于 Token 验证请求幂等性, 通常应用于 RestAPI 方法
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RequiredArgsConstructor
public final class IdempotentTokenExecuteHandler extends AbstractIdempotentTemplate implements IdempotentTokenService {
    
    private final DistributedCache distributedCache;
    private final IdempotentProperties idempotentProperties;
    
    private static final String TOKEN_KEY = "idempotent-token";
    private static final String TOKEN_PREFIX_KEY = "idempotent:token:";
    private static final long TOKEN_EXPIRED_TIME = 6000;
    
    @Override
    protected IdempotentParamWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        return new IdempotentParamWrapper();
    }
    
    @Override
    public String createToken() {
        String token = Optional.ofNullable(Strings.emptyToNull(idempotentProperties.getPrefix())).orElse(TOKEN_PREFIX_KEY) + UUID.randomUUID();
        distributedCache.put(token, "", Optional.ofNullable(idempotentProperties.getTimeout()).orElse(TOKEN_EXPIRED_TIME));
        return token;
    }
    
    @Override
    public void handler(IdempotentParamWrapper wrapper) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader(TOKEN_KEY);
        if (StrUtil.isBlank(token)) {
            token = request.getParameter(TOKEN_KEY);
            if (StrUtil.isBlank(token)) {
                throw new ClientException(BaseErrorCode.IDEMPOTENT_TOKEN_NULL_ERROR);
            }
        }
        Boolean tokenDelFlag = distributedCache.delete(token);
        if (!tokenDelFlag) {
            String errMsg = StrUtil.isNotBlank(wrapper.getIdempotent().message())
                    ? wrapper.getIdempotent().message()
                    : BaseErrorCode.IDEMPOTENT_TOKEN_DELETE_ERROR.message();
            throw new ClientException(errMsg, BaseErrorCode.IDEMPOTENT_TOKEN_DELETE_ERROR);
        }
    }
}