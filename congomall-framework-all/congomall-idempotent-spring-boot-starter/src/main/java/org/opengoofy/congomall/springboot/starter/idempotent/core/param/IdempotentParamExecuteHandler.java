

package org.opengoofy.congomall.springboot.starter.idempotent.core.param;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import org.opengoofy.congomall.springboot.starter.idempotent.core.AbstractIdempotentTemplate;
import org.opengoofy.congomall.springboot.starter.idempotent.core.IdempotentContext;
import org.opengoofy.congomall.springboot.starter.idempotent.core.IdempotentParamWrapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 基于方法参数验证请求幂等性
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RequiredArgsConstructor
public final class IdempotentParamExecuteHandler extends AbstractIdempotentTemplate implements IdempotentParamService {
    
    private final RedissonClient redissonClient;
    
    private final static String LOCK = "lock:param:restAPI";
    
    @Override
    protected IdempotentParamWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        String lockKey = String.format("idempotent:path:%s:currentUserId:%s:md5:%s", getServletPath(), getCurrentUserId(), calcArgsMD5(joinPoint));
        return IdempotentParamWrapper.builder().lockKey(lockKey).build();
    }
    
    /**
     * @return 获取当前线程上下文 ServletPath
     */
    private String getServletPath() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest().getServletPath();
    }
    
    /**
     * @return 当前操作用户 ID
     */
    private String getCurrentUserId() {
        return null;
    }
    
    /**
     * @return joinPoint md5
     */
    private String calcArgsMD5(ProceedingJoinPoint joinPoint) {
        String md5 = DigestUtil.md5Hex(JSON.toJSONBytes(joinPoint.getArgs()));
        return md5;
    }
    
    @Override
    public void handler(IdempotentParamWrapper wrapper) {
        String lockKey = wrapper.getLockKey();
        RLock lock = redissonClient.getLock(lockKey);
        if (!lock.tryLock()) {
            throw new ClientException(wrapper.getIdempotent().message());
        }
        IdempotentContext.put(LOCK, lock);
    }
    
    @Override
    public void postProcessing() {
        RLock lock = null;
        try {
            lock = (RLock) IdempotentContext.getKey(LOCK);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }
}
