

package org.opengoofy.congomall.biz.customer.user.domain.dto;

import lombok.Data;

/**
 * C 端用户
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CustomerUserDTO {
    
    /**
     * id
     */
    private Long id;
    
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
    
    /**
     * 邮箱
     */
    private String mail;
    
    /**
     * 年龄
     */
    private Integer age;
    
    /**
     * 性别
     */
    private Integer gender;
    
    /**
     * 头像
     */
    private String avatar;
}
