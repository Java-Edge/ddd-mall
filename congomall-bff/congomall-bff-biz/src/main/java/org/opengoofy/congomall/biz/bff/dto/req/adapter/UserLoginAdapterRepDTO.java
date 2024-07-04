

package org.opengoofy.congomall.biz.bff.dto.req.adapter;

import lombok.Data;

/**
 * 用户登录适配请求对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class UserLoginAdapterRepDTO {
    
    private String challenge;
    
    private String seccode;
    
    private String statusKey;
    
    private String userName;
    
    private String userPwd;
    
    private String validate;
    
    private String loginType;
}
