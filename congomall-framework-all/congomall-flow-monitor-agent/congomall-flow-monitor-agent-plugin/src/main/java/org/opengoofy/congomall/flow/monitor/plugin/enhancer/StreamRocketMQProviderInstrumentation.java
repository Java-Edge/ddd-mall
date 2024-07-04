

package org.opengoofy.congomall.flow.monitor.plugin.enhancer;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.opengoofy.congomall.flow.monitor.core.define.ClassEnhancePluginDefine;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.opengoofy.congomall.flow.monitor.core.conf.Config.Agent.SPRING_CLOUD_STREAM_ROCKETMQ_PROVIDER_ENHANCE_CLASS;

/**
 * SpringCloud Stream RocketMQ 生产端切面拦截定义
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class StreamRocketMQProviderInstrumentation implements ClassEnhancePluginDefine {
    
    private static final String ENHANCE_CLASS = SPRING_CLOUD_STREAM_ROCKETMQ_PROVIDER_ENHANCE_CLASS;
    private static final String ENHANCE_METHOD = "doSend";
    private static final String INTERCEPT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.StreamRocketMQProviderInterceptor";
    
    @Override
    public ElementMatcher.Junction enhanceClass() {
        return named(ENHANCE_CLASS).and(not(isInterface()));
    }
    
    @Override
    public ElementMatcher<MethodDescription> getMethodsMatcher() {
        return named(ENHANCE_METHOD).and(ElementMatchers.isProtected()).and(takesArguments(2));
    }
    
    @Override
    public String getMethodsEnhancer() {
        return INTERCEPT_CLASS;
    }
}
