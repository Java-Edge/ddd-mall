

package org.opengoofy.congomall.biz.customer.user.application.resp;

import lombok.Data;

/**
 * 用户注册响应
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class UserRegisterRespDTO {
    
    /**
     * 昵称
     */
    private String name;
    
    /**
     * 账号
     */
    private String accountNumber;
    
    /**
     * 手机号
     */
    private String phone;
}
