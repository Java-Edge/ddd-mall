

package org.opengoofy.congomall.springboot.starter.cache.core;

/**
 * 缓存加载器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FunctionalInterface
public interface CacheLoader<T> {
    
    /**
     * 加载缓存
     *
     * @return
     */
    T load();
}
