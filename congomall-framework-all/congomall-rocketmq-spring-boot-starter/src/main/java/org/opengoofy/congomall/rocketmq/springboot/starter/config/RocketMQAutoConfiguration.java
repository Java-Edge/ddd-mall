

package org.opengoofy.congomall.rocketmq.springboot.starter.config;

import org.opengoofy.congomall.rocketmq.springboot.starter.aspect.StreamListenerLogPrintAspect;
import org.springframework.context.annotation.Bean;

/**
 * RocketMQ 自动装配
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class RocketMQAutoConfiguration {
    
    @Bean
    public StreamListenerLogPrintAspect streamListenerLogPrintAspect() {
        return new StreamListenerLogPrintAspect();
    }
}
