

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.dto.req.adapter.UserLoginAdapterRepDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.GeeTestAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.UserLoginAdapterRespDTO;

/**
 * 用户登录接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface UserLoginService {
    
    /**
     * C 端用户登录
     *
     * @param requestParam 用户登录入参
     * @return 用户登录返回信息
     */
    UserLoginAdapterRespDTO login(UserLoginAdapterRepDTO requestParam);
    
    /**
     * 检查 C 端用户是否登录
     *
     * @param token JWT Token
     * @return 用户是否登录
     */
    UserLoginAdapterRespDTO checkLogin(String token);
    
    /**
     * 获取极验配置
     *
     * @return 初始化后极验配置
     */
    GeeTestAdapterRespDTO initGeeTestConfig();
    
    /**
     * 用户退出登录
     *
     * @param accessToken 用户登录 Token
     */
    void logout(String accessToken);
}
