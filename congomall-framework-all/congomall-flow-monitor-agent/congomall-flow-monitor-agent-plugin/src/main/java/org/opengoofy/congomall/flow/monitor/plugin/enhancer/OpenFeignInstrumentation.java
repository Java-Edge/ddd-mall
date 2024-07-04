

package org.opengoofy.congomall.flow.monitor.plugin.enhancer;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import org.opengoofy.congomall.flow.monitor.core.define.ClassEnhancePluginDefine;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.opengoofy.congomall.flow.monitor.core.conf.Config.Agent.OPEN_FEIGN_ENHANCE_CLASS;

/**
 * OpenFeign 流量拦截
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class OpenFeignInstrumentation implements ClassEnhancePluginDefine {
    
    private static final String ENHANCE_CLASS = OPEN_FEIGN_ENHANCE_CLASS;
    private static final String ENHANCE_METHOD = "execute";
    private static final String INTERCEPT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.OpenFeignInterceptor";
    
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
