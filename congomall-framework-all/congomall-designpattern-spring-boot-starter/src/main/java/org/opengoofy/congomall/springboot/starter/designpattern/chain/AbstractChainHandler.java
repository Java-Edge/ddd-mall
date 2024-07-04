package org.opengoofy.congomall.springboot.starter.designpattern.chain;

import org.springframework.core.Ordered;

/**
 * 抽象业务责任链组件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface AbstractChainHandler<T> extends Ordered {
    
    /**
     * 执行责任链逻辑
     *
     * @param requestParam 责任链执行入参
     */
    void handler(T requestParam);
    
    /**
     * @return 责任链组件标识
     */
    String mark();
}
