

package org.opengoofy.congomall.biz.pay.domain.repository;

import org.opengoofy.congomall.biz.pay.domain.aggregate.Pay;

/**
 * 支付仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PayRepository {
    
    /**
     * 创建支付单
     *
     * @param pay 支付聚合根
     */
    void createPay(Pay pay);
    
    /**
     * 支付单回调
     *
     * @param pay 支付聚合根
     */
    void callbackPay(Pay pay);
}
