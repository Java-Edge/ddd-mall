package org.opengoofy.congomall.biz.order.infrastructure.mq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.order.domain.aggregate.Order;
import org.opengoofy.congomall.biz.order.domain.common.OrderStatusEnum;
import org.opengoofy.congomall.biz.order.domain.event.PayResultNotifyMessageEvent;
import org.opengoofy.congomall.biz.order.domain.repository.OrderRepository;
import org.opengoofy.congomall.biz.order.infrastructure.mq.messaging.OrderSink;
import org.opengoofy.congomall.rocketmq.springboot.starter.core.MessageWrapper;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 支付结果通知消息消费者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PayResultNotifyMessageConsumer {
    
    private final OrderRepository orderRepository;
    
    @StreamListener(OrderSink.PAY_RESULT_NOTIFY)
    public void delayCloseOrderConsumer(MessageWrapper<PayResultNotifyMessageEvent> messageWrapper) {
        PayResultNotifyMessageEvent event = messageWrapper.getMessage();
        Order order = Order.builder()
                .orderSn(event.getOrderSn())
                .status(OrderStatusEnum.TO_BE_DELIVERED.getStatus())
                .build();
        orderRepository.statusReversal(order);
    }
}
