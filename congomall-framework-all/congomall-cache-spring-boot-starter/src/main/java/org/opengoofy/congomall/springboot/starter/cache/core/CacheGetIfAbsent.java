

package org.opengoofy.congomall.springboot.starter.cache.core;

/**
 * 缓存查询为空
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FunctionalInterface
public interface CacheGetIfAbsent<T> {
    
    /**
     * 如果查询结果为空，执行逻辑
     *
     * @param param
     */
    void execute(T param);
}
