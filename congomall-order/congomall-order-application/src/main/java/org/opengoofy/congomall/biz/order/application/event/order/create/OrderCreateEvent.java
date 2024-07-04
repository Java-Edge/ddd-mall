package org.opengoofy.congomall.biz.order.application.event.order.create;

import lombok.Getter;
import org.opengoofy.congomall.biz.order.domain.aggregate.Order;
import org.springframework.context.ApplicationEvent;

/**
 * 订单创建事件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class OrderCreateEvent extends ApplicationEvent {
    
    /**
     * 订单聚合根
     */
    @Getter
    private Order order;
    
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public OrderCreateEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
