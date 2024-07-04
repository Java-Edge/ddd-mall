package org.opengoofy.congomall.biz.customer.user.application.service.handler;

import org.opengoofy.congomall.biz.customer.user.application.assembler.CustomerUserToDTOAssembler;
import org.opengoofy.congomall.biz.customer.user.application.req.UserRegisterCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserRegisterRespDTO;
import org.opengoofy.congomall.biz.customer.user.domain.dp.*;
import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import org.opengoofy.congomall.biz.customer.user.domain.repository.CustomerUserRepository;
import org.opengoofy.congomall.ddd.framework.core.domain.CommandHandler;
import org.opengoofy.congomall.springboot.starter.cache.DistributedCache;
import org.opengoofy.congomall.springboot.starter.cache.toolkit.CacheUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static org.opengoofy.congomall.biz.customer.user.domain.common.CacheConstant.REGISTER_USER_VERIFY_CODE;

/**
 * C 端用户注册处理器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@AllArgsConstructor
public class CustomerUserRegisterCommandHandler implements CommandHandler<UserRegisterCommand, UserRegisterRespDTO> {
    
    private final CustomerUserRepository customerUserRepository;
    
    private final CustomerUserToDTOAssembler customerUserAssembler;
    
    private final DistributedCache distributedCache;
    
    @Override
    public UserRegisterRespDTO handler(UserRegisterCommand requestParam) {
        CustomerUser customerUser = CustomerUser.builder()
                .username(new CustomerUserName(requestParam.getUsername()))
                .phone(new CustomerUserPhone(requestParam.getPhone()))
                .accountNumber(new CustomerUserAccountNumber(requestParam.getAccountNumber()))
                .password(new CustomerUserPassword(requestParam.getPassword()))
                .mail(new CustomerUserMail(requestParam.getMail()))
                .receiver(requestParam.getMail())
                .verifyCode(requestParam.getMailValidCode())
                .build();
        // 获取缓存中的验证码
        String buildKey = CacheUtil.buildKey(REGISTER_USER_VERIFY_CODE, customerUser.getReceiver());
        String verifyCode = distributedCache.get(buildKey, String.class);
        // 检查验证码正确性
        customerUser.checkoutValidCode(verifyCode);
        CustomerUser result = customerUserRepository.register(customerUser);
        // 删除缓存验证码
        distributedCache.delete(buildKey);
        return customerUserAssembler.customerUserToUserRegisterRespDTO(result);
    }
}
