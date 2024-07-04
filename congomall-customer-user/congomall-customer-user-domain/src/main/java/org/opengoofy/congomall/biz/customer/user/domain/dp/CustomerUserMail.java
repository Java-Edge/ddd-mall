

package org.opengoofy.congomall.biz.customer.user.domain.dp;

import lombok.Data;

/**
 * C 端用户邮箱
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CustomerUserMail {
    
    /**
     * 邮箱
     */
    private final String mail;
    
    public CustomerUserMail(String mail) {
        this.mail = mail;
    }
}
