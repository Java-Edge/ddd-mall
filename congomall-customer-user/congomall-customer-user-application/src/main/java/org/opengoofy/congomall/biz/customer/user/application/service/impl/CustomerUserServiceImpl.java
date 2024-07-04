

package org.opengoofy.congomall.biz.customer.user.application.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.UserLoginCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserRegisterCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserRegisterRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.service.CustomerUserService;
import org.opengoofy.congomall.biz.customer.user.application.service.handler.login.MailLoginCommandHandler;
import org.opengoofy.congomall.biz.customer.user.application.service.handler.verify.MailLoginVerifyCommandHandler;
import org.opengoofy.congomall.biz.customer.user.application.service.handler.verify.MailRegisterVerifyCommandHandler;
import org.opengoofy.congomall.ddd.framework.core.domain.CommandHandler;
import org.opengoofy.congomall.springboot.starter.cache.DistributedCache;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractStrategyChoose;
import org.springframework.stereotype.Service;

/**
 * C 端用户接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@AllArgsConstructor
public class CustomerUserServiceImpl implements CustomerUserService {
    
    private final DistributedCache distributedCache;
    private final AbstractStrategyChoose abstractStrategyChoose;
    private final CommandHandler<UserRegisterCommand, UserRegisterRespDTO> customerUserRegisterCommandHandler;
    
    @Override
    public void verifyCodeSend(UserVerifyCodeCommand requestParam) {
        String mark = requestParam.getType() + "_" + requestParam.getPlatform();
        /**
         * site
         * {@link MailLoginVerifyCommandHandler}
         * {@link MailRegisterVerifyCommandHandler}
         * ...
         */
        // 策略模式: 根据 mark 选择用户登录或者注册逻辑
        abstractStrategyChoose.chooseAndExecute(mark, requestParam);
    }
    
    @Override
    public UserRegisterRespDTO register(UserRegisterCommand requestParam) {
        UserRegisterRespDTO result = customerUserRegisterCommandHandler.handler(requestParam);
        return result;
    }
    
    @Override
    public UserLoginRespDTO login(UserLoginCommand requestParam) {
        /**
         * site
         * {@link MailLoginCommandHandler}
         */
        return abstractStrategyChoose.chooseAndExecuteResp(requestParam.getLoginType(), requestParam);
    }
    
    @Override
    public UserLoginRespDTO checkLogin(String accessToken) {
        return distributedCache.get(accessToken, UserLoginRespDTO.class);
    }
    
    @Override
    public void logout(String accessToken) {
        if (StrUtil.isNotBlank(accessToken)) {
            distributedCache.delete(accessToken);
        }
    }
}
