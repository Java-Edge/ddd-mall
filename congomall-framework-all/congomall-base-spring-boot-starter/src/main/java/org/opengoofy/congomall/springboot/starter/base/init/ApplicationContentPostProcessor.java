package org.opengoofy.congomall.springboot.starter.base.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

import javax.annotation.Resource;

/**
 * 应用初始化后置处理器，防止Spring事件被多次执行
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class ApplicationContentPostProcessor implements ApplicationListener<ApplicationReadyEvent> {
    
    @Resource
    private ApplicationContext applicationContext;
    
    /**
     * 执行标识，确保Spring事件 {@link ApplicationReadyEvent} 有且执行一次
     */
    private boolean executeOnlyOnce = true;
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        synchronized (ApplicationContentPostProcessor.class) {
            if (executeOnlyOnce) {
                applicationContext.publishEvent(new ApplicationInitializingEvent(this));
                executeOnlyOnce = false;
            }
        }
    }
}
