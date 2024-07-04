

package org.opengoofy.congomall.flow.monitor.plugin.context;

import org.opengoofy.congomall.flow.monitor.plugin.enhancer.SpringApplicationInstrumentation;
import org.opengoofy.congomall.flow.monitor.plugin.enhancer.SpringApplicationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Spring 应用上下文代理
 * 应用于 Agent 运行时获取 Spring 上下文中 Bean 对象
 *
 * <p>
 * 通过增强 SpringApplication，执行 {@link SpringApplication#run(String...)} 方法后拿到对应容器赋值 {@link ApplicationContextHolderProxy#applicationContext}
 * 切面以及增强查看 {@link SpringApplicationInstrumentation} {@link SpringApplicationInterceptor}
 * </p>
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class ApplicationContextHolderProxy {
    
    private static ApplicationContext applicationContext;
    
    /**
     * 根据类型获取 IOC 容器 Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    
    /**
     * 根据名称 & 类型获取 IOC 容器 Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
    
    /**
     * 根据类型获取一组 IOC 容器 Bean
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }
    
    /**
     * 查找 Bean 是否有注释
     */
    public static <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) {
        return applicationContext.findAnnotationOnBean(beanName, annotationType);
    }
    
    /**
     * 获取 Spring 应用上下文
     */
    public static ApplicationContext getInstance() {
        return applicationContext;
    }
    
    /**
     * 初始化上下文
     */
    public static void initContext(ApplicationContext context) {
        applicationContext = context;
    }
}
