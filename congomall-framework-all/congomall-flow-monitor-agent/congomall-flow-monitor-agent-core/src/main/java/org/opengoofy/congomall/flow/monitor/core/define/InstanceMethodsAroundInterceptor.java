

package org.opengoofy.congomall.flow.monitor.core.define;

import java.lang.reflect.Method;

/**
 * 类切面增强定义
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface InstanceMethodsAroundInterceptor {
    
    /**
     * 在目标方法执行前调用
     */
    void beforeMethod(Object obj, Method method, Object[] allArguments, Class<?>[] argumentsTypes) throws Throwable;
    
    /**
     * 在目标方法执行后调用
     */
    void afterMethod(Object obj, Method method, Object[] allArguments, Class<?>[] argumentsTypes, Object result, Throwable ex) throws Throwable;
}
