package org.opengoofy.congomall.biz.order.application.filter.base;

import org.opengoofy.congomall.biz.order.application.enums.OrderChainMarkEnum;
import org.opengoofy.congomall.biz.order.application.req.OrderCreateCommand;
import org.opengoofy.congomall.springboot.starter.designpattern.chain.AbstractChainHandler;

/**
 * 订单创建责任链过滤器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface OrderCreateChainFilter<T extends OrderCreateCommand> extends AbstractChainHandler<OrderCreateCommand> {
    
    @Override
    default String mark() {
        return OrderChainMarkEnum.ORDER_CREATE_FILTER.name();
    }
}
