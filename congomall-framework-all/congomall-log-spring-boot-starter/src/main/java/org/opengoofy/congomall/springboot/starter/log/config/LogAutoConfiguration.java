

package org.opengoofy.congomall.springboot.starter.log.config;

import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.log.aspect.MLogPrintAspect;
import org.springframework.context.annotation.Bean;

/**
 * 日志自动装配
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class LogAutoConfiguration {
    
    /**
     * {@link MLog} 日志打印 AOP 切面
     */
    @Bean
    public MLogPrintAspect mLogPrintAspect() {
        return new MLogPrintAspect();
    }
}
