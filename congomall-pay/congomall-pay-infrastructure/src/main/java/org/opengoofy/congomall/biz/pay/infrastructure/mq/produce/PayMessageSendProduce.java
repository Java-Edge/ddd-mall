

package org.opengoofy.congomall.biz.pay.infrastructure.mq.produce;

import cn.hutool.core.date.SystemClock;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.opengoofy.congomall.biz.pay.domain.common.MessageRocketMQConstants;
import org.opengoofy.congomall.biz.pay.domain.event.PayResultNotifyMessageEvent;
import org.opengoofy.congomall.rocketmq.springboot.starter.core.MessageWrapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 支付消息通用发送生产者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@AllArgsConstructor
public class PayMessageSendProduce {
    
    private final MessageChannel payOutput;
    
    /**
     * 支付消息通用发送
     *
     * @param event 支付结果消息发送事件
     */
    public void payResultNotifyMessageSend(PayResultNotifyMessageEvent event) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(new MessageWrapper(keys, event))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, MessageRocketMQConstants.PAY_RESULT_MESSAGE_SEND_TAG)
                .build();
        long startTime = SystemClock.now();
        boolean sendResult = false;
        try {
            sendResult = payOutput.send(message, 2000L);
        } finally {
            log.info("支付结果通知消息发送，发送状态：{}，Keys：{}，执行时间：{} ms，消息内容：{}", sendResult, keys, SystemClock.now() - startTime, JSON.toJSONString(event));
        }
    }
}
