

package org.opengoofy.congomall.biz.message.infrastructure.mq.consume;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;
import org.opengoofy.congomall.biz.message.domain.event.MailMessageSendEvent;
import org.opengoofy.congomall.biz.message.infrastructure.facade.MessageSendFacade;
import org.opengoofy.congomall.biz.message.infrastructure.mq.messaging.MessageSink;
import org.opengoofy.congomall.springboot.starter.idempotent.annotation.Idempotent;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentSceneEnum;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentTypeEnum;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 邮箱消息发送消费者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MailMessageSendConsume {
    
    private final MessageSendFacade messageSendFacade;
    
    @Idempotent(
            uniqueKeyPrefix = "mail_message_send:",
            key = "#event.messageSendId+'_'+#event.hashCode()",
            type = IdempotentTypeEnum.SPEL,
            scene = IdempotentSceneEnum.MQ,
            keyTimeout = 600L
    )
    @StreamListener(MessageSink.MAIL_SEND)
    public void mailMessageSend(@Payload MailMessageSendEvent event, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            MessageSend messageSend = BeanUtil.toBean(event, MessageSend.class);
            // 外观模式: 抽象消息发送、消息存储以及失败回调业务方等逻辑
            messageSendFacade.mailMessageSend(messageSend);
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(event));
        }
    }
}
