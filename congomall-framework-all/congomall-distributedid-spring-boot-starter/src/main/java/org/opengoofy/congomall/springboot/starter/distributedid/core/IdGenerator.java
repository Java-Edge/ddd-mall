

package org.opengoofy.congomall.springboot.starter.distributedid.core;

/**
 * ID 生成器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface IdGenerator {
    
    /**
     * 下一个 ID
     */
    default long nextId() {
        return 0L;
    }
    
    /**
     * 下一个 ID 字符串
     */
    default String nextIdStr() {
        return "";
    }
}
