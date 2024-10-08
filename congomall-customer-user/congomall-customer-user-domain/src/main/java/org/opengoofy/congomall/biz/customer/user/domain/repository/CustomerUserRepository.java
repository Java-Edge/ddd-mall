

package org.opengoofy.congomall.biz.customer.user.domain.repository;

import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;

/**
 * C 端用户仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface CustomerUserRepository {
    
    /**
     * 根据 customerUserId 查询 C 端用户
     *
     * @param customerUserId
     * @return
     */
    CustomerUser find(Long customerUserId);
    
    /**
     * 根据 mail 查询 C 端用户
     *
     * @param mail
     * @return
     */
    CustomerUser findByMail(String mail);
    
    /**
     * 根据 accountNumber 查询 C 端用户
     *
     * @param accountNumber
     * @return
     */
    CustomerUser findByAccountNumber(String accountNumber);
    
    /**
     * C 端用户注册
     *
     * @param customerUser
     * @return
     */
    CustomerUser register(CustomerUser customerUser);
    
    /**
     * 保存用户操作日志
     *
     * @param customerUser
     */
    void saveOperationLog(CustomerUser customerUser);
}
