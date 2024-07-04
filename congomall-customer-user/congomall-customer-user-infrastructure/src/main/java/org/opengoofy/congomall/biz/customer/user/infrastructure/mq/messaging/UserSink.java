

package org.opengoofy.congomall.biz.customer.user.infrastructure.mq.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 用户 Sink
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface UserSink {
    
    /**
     * Name of the input channel.
     */
    String INPUT = "userInput";
    
    /**
     * @return input channel
     */
    @Input(UserSink.INPUT)
    SubscribableChannel userInput();
}
