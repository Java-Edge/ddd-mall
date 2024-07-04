

package org.opengoofy.congomall.biz.customer.user.application.service;

import org.opengoofy.congomall.biz.customer.user.application.req.UserLoginCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserRegisterCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserRegisterRespDTO;

/**
 * C 端用户接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface CustomerUserService {
    
    /**
     * C 端用户验证
     *
     * @param requestParam 验证用户入参
     */
    void verifyCodeSend(UserVerifyCodeCommand requestParam);
    
    /**
     * C 端用户注册
     *
     * @param requestParam 注册用户入参
     * @return 注册用户成功后信息
     */
    UserRegisterRespDTO register(UserRegisterCommand requestParam);
    
    /**
     * C 端用户登录
     *
     * @param requestParam 用户登录入参
     * @return 用户登录返回信息
     */
    UserLoginRespDTO login(UserLoginCommand requestParam);
    
    /**
     * 通过 Token 检查用户是否登录
     *
     * @param accessToken 用户登录 Token
     * @return 用户登录信息
     */
    UserLoginRespDTO checkLogin(String accessToken);
    
    /**
     * 用户退出登录
     *
     * @param accessToken 用户登录 Token
     */
    void logout(String accessToken);
}
