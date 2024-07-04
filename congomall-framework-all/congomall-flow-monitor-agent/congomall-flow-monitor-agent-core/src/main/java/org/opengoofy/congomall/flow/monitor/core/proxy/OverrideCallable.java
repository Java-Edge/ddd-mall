

package org.opengoofy.congomall.flow.monitor.core.proxy;

/**
 * 覆盖可调用接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface OverrideCallable {
    
    /**
     * 接口调用
     *
     * @param args
     * @return
     */
    Object call(Object[] args);
}
