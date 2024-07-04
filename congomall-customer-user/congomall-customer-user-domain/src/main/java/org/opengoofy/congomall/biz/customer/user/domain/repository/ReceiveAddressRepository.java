

package org.opengoofy.congomall.biz.customer.user.domain.repository;

import org.opengoofy.congomall.biz.customer.user.domain.mode.ReceiveAddress;

import java.util.List;

/**
 * 用户收货地址仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ReceiveAddressRepository {
    
    /**
     * 根据用户 ID 查询收货地址
     *
     * @param customerUserId 用户 ID
     * @return 用户收货地址集合
     */
    List<ReceiveAddress> listReceiveAddressByCustomerUserId(String customerUserId);
    
    /**
     * 新增用户收货地址
     *
     * @param receiveAddress 用户收货地址聚合根
     */
    void saveReceiveAddress(ReceiveAddress receiveAddress);
    
    /**
     * 根据用户 ID、收货地址 ID 删除收货地址
     *
     * @param customerUserId   用户 ID
     * @param receiveAddressId 收货地址 ID
     */
    void removeReceiveAddress(String customerUserId, String receiveAddressId);
    
    /**
     * 修改用户收货地址
     *
     * @param receiveAddress 用户收货地址聚合根
     */
    void updateReceiveAddress(ReceiveAddress receiveAddress);
}
