

package org.opengoofy.congomall.biz.customer.user.application.service.handler.login;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.UserLoginCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import org.opengoofy.congomall.biz.customer.user.domain.common.UserLoginTypeEnum;
import org.opengoofy.congomall.biz.customer.user.domain.dp.CustomerUserAccountNumber;
import org.opengoofy.congomall.biz.customer.user.domain.dp.CustomerUserPassword;
import org.opengoofy.congomall.biz.customer.user.domain.repository.CustomerUserRepository;
import org.opengoofy.congomall.springboot.starter.cache.DistributedCache;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractExecuteStrategy;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 账号登录
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@AllArgsConstructor
public class AccountLoginCommandHandler implements AbstractExecuteStrategy<UserLoginCommand, UserLoginRespDTO> {
    
    private final DistributedCache distributedCache;
    private final CustomerUserRepository customerUserRepository;
    
    @Override
    public String mark() {
        return UserLoginTypeEnum.USER_LOGIN_ACCOUNT.toString();
    }
    
    @Override
    public UserLoginRespDTO executeResp(UserLoginCommand requestParam) {
        CustomerUser customerUser = CustomerUser.builder()
                .accountNumber(new CustomerUserAccountNumber(requestParam.getAccountNumber()))
                .password(new CustomerUserPassword(requestParam.getPassword()))
                .build();
        CustomerUser actual = customerUserRepository.findByAccountNumber(requestParam.getAccountNumber());
        if (actual == null) {
            throw new ClientException("用户名不存在");
        }
        if (!Objects.equals(customerUser.getPassword(), actual.getPassword())) {
            throw new ClientException("用户名密码错误");
        }
        String accessToken = actual.generateAccessToken();
        distributedCache.put(accessToken, JSON.toJSONString(actual), 30, TimeUnit.MINUTES);
        return new UserLoginRespDTO(actual.getCustomerUserId(), actual.getUsername(), actual.getAccountNumber(), accessToken);
    }
}
