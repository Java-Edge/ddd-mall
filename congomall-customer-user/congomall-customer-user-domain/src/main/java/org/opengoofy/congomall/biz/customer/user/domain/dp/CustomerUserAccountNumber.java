

package org.opengoofy.congomall.biz.customer.user.domain.dp;

import lombok.Data;

/**
 * C 端用户账号
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CustomerUserAccountNumber {
    
    /**
     * 账号
     */
    private String accountNumber;
    
    public CustomerUserAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
