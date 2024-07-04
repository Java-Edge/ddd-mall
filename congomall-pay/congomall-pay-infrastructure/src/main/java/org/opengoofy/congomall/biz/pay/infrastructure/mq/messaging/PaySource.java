

package org.opengoofy.congomall.biz.pay.infrastructure.mq.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 支付 Source
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PaySource {
    
    /**
     * Name of the output channel.
     */
    String OUTPUT = "payOutput";
    
    /**
     * @return output channel
     */
    @Output(PaySource.OUTPUT)
    MessageChannel payOutput();
}
