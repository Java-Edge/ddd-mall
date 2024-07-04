

package org.opengoofy.congomall.biz.message.infrastructure.mq.produce;

import cn.hutool.core.date.SystemClock;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.opengoofy.congomall.biz.message.domain.common.MessageRocketMQConstants;
import org.opengoofy.congomall.biz.message.domain.event.MailMessageSendEvent;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 消息发送生产者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@AllArgsConstructor
public class MessageSendProduce {
    
    private final MessageChannel messageOutput;
    
    /**
     * 邮箱消息发送
     *
     * @param mailMessageSendEvent
     */
    public void mailMessageSend(MailMessageSendEvent mailMessageSendEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(JSON.toJSONString(mailMessageSendEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, MessageRocketMQConstants.MESSAGE_MAIL_SEND_TAG)
                .build();
        long startTime = SystemClock.now();
        boolean sendResult = false;
        try {
            sendResult = messageOutput.send(message, 2000L);
        } finally {
            log.info("邮箱消息发送，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, SystemClock.now() - startTime, JSON.toJSONString(mailMessageSendEvent));
        }
    }
}
