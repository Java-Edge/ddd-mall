

package org.opengoofy.congomall.flow.monitor.core.define;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;

/**
 * 切面增强定义
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ClassEnhancePluginDefine {
    
    /**
     * 定义需增强的类
     */
    ElementMatcher.Junction enhanceClass();
    
    /**
     * 定义需增强的方法
     */
    ElementMatcher<MethodDescription> getMethodsMatcher();
    
    /**
     * 切面增强类
     */
    String getMethodsEnhancer();
}
