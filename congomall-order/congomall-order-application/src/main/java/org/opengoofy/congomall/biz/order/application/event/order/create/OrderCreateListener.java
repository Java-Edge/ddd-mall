package org.opengoofy.congomall.biz.order.application.event.order.create;

import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.order.domain.repository.OrderRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 订单创建监听
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Order(0)
@Component
@RequiredArgsConstructor
public final class OrderCreateListener implements ApplicationListener<OrderCreateEvent> {
    
    private final OrderRepository orderRepository;
    
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        orderRepository.createOrder(event.getOrder());
    }
}
