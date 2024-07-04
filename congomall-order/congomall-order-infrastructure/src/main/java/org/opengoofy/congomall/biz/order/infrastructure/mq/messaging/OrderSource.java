

package org.opengoofy.congomall.biz.order.infrastructure.mq.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 订单 Source
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface OrderSource {
    
    /**
     * Name of the output channel.
     */
    String OUTPUT = "orderOutput";
    
    /**
     * @return output channel
     */
    @Output(OrderSource.OUTPUT)
    MessageChannel orderOutput();
}
