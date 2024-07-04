

package org.opengoofy.congomall.biz.customer.user.domain.dp;

import lombok.Data;

/**
 * C 端用户密码
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CustomerUserPassword {
    
    /**
     * 用户密码
     */
    private String password;
    
    public CustomerUserPassword(String password) {
        this.password = password;
    }
}
