package org.opengoofy.congomall.biz.order.application.event.order.create;

import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.order.domain.dto.ProductSkuStockDTO;
import org.opengoofy.congomall.biz.order.domain.event.DelayCloseOrderEvent;
import org.opengoofy.congomall.biz.order.infrastructure.mq.provide.DelayCloseOrderProvide;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * 发送延迟队列取消未付款订单监听
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Order(3)
@Component
@RequiredArgsConstructor
public class DelayCloseOrderListener implements ApplicationListener<OrderCreateEvent> {
    
    private final DelayCloseOrderProvide delayCloseOrderProvide;
    
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        delayCloseOrderProvide.delayCloseOrderSend(
                new DelayCloseOrderEvent(
                        event.getOrder().getOrderSn(),
                        event.getOrder().getOrderProducts().stream()
                                .map(each -> new ProductSkuStockDTO(String.valueOf(each.getProductId()), String.valueOf(each.getProductSkuId()), each.getProductQuantity()))
                                .collect(Collectors.toList())));
    }
}