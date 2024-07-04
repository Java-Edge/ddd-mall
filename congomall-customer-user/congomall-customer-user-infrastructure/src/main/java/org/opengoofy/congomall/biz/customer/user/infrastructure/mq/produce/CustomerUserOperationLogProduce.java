package org.opengoofy.congomall.biz.customer.user.infrastructure.mq.produce;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.opengoofy.congomall.biz.customer.user.domain.common.RocketMQConstants;
import org.opengoofy.congomall.biz.customer.user.domain.event.OperationLogEvent;
import org.opengoofy.congomall.rocketmq.springboot.starter.core.MessageWrapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * C 端用户操作日志消息生产者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@AllArgsConstructor
public class CustomerUserOperationLogProduce {
    
    private final MessageChannel userOutput;
    
    /**
     * 记录 C 用户用户变更日志
     *
     * @param customerOperationLogEvent
     */
    public void recordCustomerUserOperationLog(OperationLogEvent customerOperationLogEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(new MessageWrapper(keys, customerOperationLogEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, RocketMQConstants.CUSTOMER_USER_OPERATION_LOG_TAG)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = userOutput.send(message, 2000L);
        } finally {
            log.info("C 端用户保存用户日志，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, System.currentTimeMillis() - startTime, JSON.toJSONString(customerOperationLogEvent));
        }
    }
}