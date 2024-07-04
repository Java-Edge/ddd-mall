

package org.opengoofy.congomall.biz.customer.user.application.service.handler.login;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.UserLoginCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import org.opengoofy.congomall.biz.customer.user.domain.common.UserLoginTypeEnum;
import org.opengoofy.congomall.biz.customer.user.domain.repository.CustomerUserRepository;
import org.opengoofy.congomall.springboot.starter.cache.DistributedCache;
import org.opengoofy.congomall.springboot.starter.cache.toolkit.CacheUtil;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractExecuteStrategy;
import org.springframework.stereotype.Component;

import static org.opengoofy.congomall.biz.customer.user.domain.common.CacheConstant.LOGIN_USER_VERIFY_CODE;

/**
 * 邮箱登录
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@AllArgsConstructor
public class MailLoginCommandHandler implements AbstractExecuteStrategy<UserLoginCommand, UserLoginRespDTO> {
    
    private final DistributedCache distributedCache;
    
    private final CustomerUserRepository customerUserRepository;
    
    @Override
    public String mark() {
        return UserLoginTypeEnum.USER_LOGIN_MAIL.name();
    }
    
    @Override
    public UserLoginRespDTO executeResp(UserLoginCommand requestParam) {
        CustomerUser customerUser = CustomerUser.builder().verifyCode(requestParam.getMailValidCode()).build();
        // 获取缓存中的验证码
        String verifyCode = distributedCache.get(CacheUtil.buildKey(LOGIN_USER_VERIFY_CODE, requestParam.getMail()), String.class);
        // 检查验证码正确性
        customerUser.checkoutValidCode(verifyCode);
        CustomerUser actual = customerUserRepository.findByMail(requestParam.getMail());
        String accessToken = actual.generateAccessToken();
        return new UserLoginRespDTO(actual.getCustomerUserId(), actual.getUsername(), actual.getAccountNumber(), accessToken);
    }
}
