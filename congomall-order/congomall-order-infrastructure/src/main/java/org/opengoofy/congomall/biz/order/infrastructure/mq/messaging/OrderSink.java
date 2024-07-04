

package org.opengoofy.congomall.biz.order.infrastructure.mq.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 订单 Sink
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface OrderSink {
    
    String DELAY_CLOSE_ORDER = "delayCloseOrder";
    
    /**
     * 延迟关闭订单
     */
    @Input(OrderSink.DELAY_CLOSE_ORDER)
    SubscribableChannel delayCloseOrder();
    
    String PAY_RESULT_NOTIFY = "payResultNotify";
    
    /**
     * 支付结果通知
     */
    @Input(OrderSink.PAY_RESULT_NOTIFY)
    SubscribableChannel payResultNotify();
}
