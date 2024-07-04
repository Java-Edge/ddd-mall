

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.Data;

/**
 * 用户登录适配返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class UserLoginAdapterRespDTO {
    
    private String address;
    
    private String balance;
    
    private String description;
    
    private String email;
    
    private String file;
    
    private String id;
    
    private String message;
    
    private String phone;
    
    private String points;
    
    private Integer sex;
    
    private Integer state;
    
    private String token;
    
    private String username;
}
