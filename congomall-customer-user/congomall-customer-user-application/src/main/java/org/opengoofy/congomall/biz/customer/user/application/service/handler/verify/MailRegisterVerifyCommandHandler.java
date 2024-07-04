

package org.opengoofy.congomall.biz.customer.user.application.service.handler.verify;

import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.domain.common.CacheConstant;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractExecuteStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户注册使用邮箱验证
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@RequiredArgsConstructor
public class MailRegisterVerifyCommandHandler extends AbstractMailVerifySender implements AbstractExecuteStrategy<UserVerifyCodeCommand, Void> {
    
    @Override
    public String mark() {
        return "customer_user_register_mail";
    }
    
    @Override
    public void execute(UserVerifyCodeCommand requestParam) {
        mailVerifySend(requestParam);
    }
    
    @Override
    protected String getCachePrefixKey() {
        return CacheConstant.REGISTER_USER_VERIFY_CODE;
    }
}
