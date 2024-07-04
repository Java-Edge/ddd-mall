

package org.opengoofy.congomall.biz.order.infrastructure.mq.provide;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.opengoofy.congomall.biz.order.domain.common.OrderRocketMQConstants;
import org.opengoofy.congomall.biz.order.domain.event.DelayCloseOrderEvent;
import org.opengoofy.congomall.rocketmq.springboot.starter.core.MessageWrapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 延迟关闭订单生产者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@AllArgsConstructor
public class DelayCloseOrderProvide {
    
    private final MessageChannel orderOutput;
    
    /**
     * 延迟发送订单关闭消息
     *
     * @param delayCloseOrderEvent 关闭事件实体
     */
    public void delayCloseOrderSend(DelayCloseOrderEvent delayCloseOrderEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(new MessageWrapper(keys, delayCloseOrderEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, OrderRocketMQConstants.DELAY_CLOSE_ORDER_TAG)
                // RocketMQ 延迟消息级别 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
                // 16 代表 30m，为了演示效果所以选择该级别，正常按照需求设置
                .setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 16)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = orderOutput.send(message, 2000L);
        } finally {
            log.info("延迟关闭订单消息发送，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, System.currentTimeMillis() - startTime, JSON.toJSONString(delayCloseOrderEvent));
        }
    }
}
