

package org.opengoofy.congomall.flow.monitor.plugin.enhancer;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import org.opengoofy.congomall.flow.monitor.core.define.ClassEnhancePluginDefine;
import org.springframework.context.ConfigurableApplicationContext;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.opengoofy.congomall.flow.monitor.core.conf.Config.Agent.SPRING_APPLICATION_ENHANCE_CLASS;

/**
 * SpringApplication 拦截，获取 Spring 应用上下文
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class SpringApplicationInstrumentation implements ClassEnhancePluginDefine {
    
    private static final String ENHANCE_CLASS = SPRING_APPLICATION_ENHANCE_CLASS;
    private static final String ENHANCE_METHOD = "run";
    private static final String INTERCEPT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.SpringApplicationInterceptor";
    
    @Override
    public ElementMatcher.Junction enhanceClass() {
        return named(ENHANCE_CLASS).and(not(isInterface()));
    }
    
    @Override
    public ElementMatcher<MethodDescription> getMethodsMatcher() {
        return named(ENHANCE_METHOD)
                .and(isPublic().and(not(isStatic())))
                .and(returns(ConfigurableApplicationContext.class))
                .and(takesArgument(0, String[].class));
    }
    
    @Override
    public String getMethodsEnhancer() {
        return INTERCEPT_CLASS;
    }
}
