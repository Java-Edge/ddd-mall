package org.opengoofy.congomall.springboot.starter.base.init;

import org.springframework.context.ApplicationEvent;

/**
 * 应用初始化事件
 *
 * <p> 规约事件，通过此事件可以查看业务系统所有初始化行为
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class ApplicationInitializingEvent extends ApplicationEvent {
    
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}
