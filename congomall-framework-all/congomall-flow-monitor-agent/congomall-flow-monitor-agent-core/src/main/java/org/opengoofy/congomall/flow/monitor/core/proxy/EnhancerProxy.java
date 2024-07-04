

package org.opengoofy.congomall.flow.monitor.core.proxy;

import net.bytebuddy.implementation.bind.annotation.*;
import org.opengoofy.congomall.flow.monitor.core.define.InstanceMethodsAroundInterceptor;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * 增强代理
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class EnhancerProxy {
    
    public InstanceMethodsAroundInterceptor enhancer;
    
    @IgnoreForBinding
    public void setEnhancer(InstanceMethodsAroundInterceptor enhancer) {
        this.enhancer = enhancer;
    }
    
    @RuntimeType
    @BindingPriority(value = 1)
    public Object intercept(@This Object obj, @AllArguments Object[] allArguments, @SuperCall Callable<?> callable,
                            @Origin Method method) throws Throwable {
        try {
            enhancer.beforeMethod(obj, method, allArguments, method.getParameterTypes());
        } catch (Throwable ignored) {
        }
        Object result = null;
        Throwable callableEx = null;
        try {
            result = callable.call();
        } catch (Throwable ex) {
            callableEx = ex;
            throw ex;
        } finally {
            try {
                enhancer.afterMethod(obj, method, allArguments, method.getParameterTypes(), result, callableEx);
            } catch (Throwable ignored) {
            }
        }
        return result;
    }
}
