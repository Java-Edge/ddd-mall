

package org.opengoofy.congomall.flow.monitor.plugin.enhancer;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import org.opengoofy.congomall.flow.monitor.core.define.ClassEnhancePluginDefine;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.opengoofy.congomall.flow.monitor.core.conf.Config.Agent.SPRING_MVC_ENHANCE_CLASS;

/**
 * Spring MVC 流量拦截
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class SpringMvcInstrumentation implements ClassEnhancePluginDefine {
    
    private static final String ENHANCE_CLASS = SPRING_MVC_ENHANCE_CLASS;
    private static final String ENHANCE_METHOD = "invokeAndHandle";
    private static final String INTERCEPT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.SpringMvcInterceptor";
    
    @Override
    public ElementMatcher.Junction enhanceClass() {
        return named(ENHANCE_CLASS).and(not(isInterface()));
    }
    
    @Override
    public ElementMatcher<MethodDescription> getMethodsMatcher() {
        return named(ENHANCE_METHOD);
    }
    
    @Override
    public String getMethodsEnhancer() {
        return INTERCEPT_CLASS;
    }
}
