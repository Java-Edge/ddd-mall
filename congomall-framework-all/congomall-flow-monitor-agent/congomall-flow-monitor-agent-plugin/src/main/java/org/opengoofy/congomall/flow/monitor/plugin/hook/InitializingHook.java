

package org.opengoofy.congomall.flow.monitor.plugin.hook;

/**
 * 初始化钩子函数
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface InitializingHook {
    
    /**
     * AgentPremain 之后执行初始化逻辑
     */
    void afterAgentPremain() throws Exception;
}
