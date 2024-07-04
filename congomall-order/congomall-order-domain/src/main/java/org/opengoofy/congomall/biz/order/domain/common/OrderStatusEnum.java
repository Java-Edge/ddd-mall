package org.opengoofy.congomall.biz.order.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@AllArgsConstructor
public enum OrderStatusEnum {
    
    /**
     * 待付款：用户选好商品下单，但还未付款的状态
     */
    PENDING_PAYMENT(0),
    
    /**
     * 待发货：用户付款后，商品未发货的状态
     */
    TO_BE_DELIVERED(1),
    
    /**
     * 已发货：已经交由物流公司，订单开始更新物流信息
     */
    SHIPPED(2),
    
    /**
     * 已完成：用户确认收货，订单已完成
     */
    COMPLETED(3),
    
    /**
     * 已关闭
     */
    CLOSED(4);
    
    @Getter
    private final int status;
}
