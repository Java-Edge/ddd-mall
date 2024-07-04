

package org.opengoofy.congomall.biz.message.infrastructure.mq.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息 Sink
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MessageSink {
    
    String MAIL_SEND = "mailSend";
    
    /**
     * 邮箱发送
     *
     * @return
     */
    @Input(MessageSink.MAIL_SEND)
    SubscribableChannel mailSend();
}
