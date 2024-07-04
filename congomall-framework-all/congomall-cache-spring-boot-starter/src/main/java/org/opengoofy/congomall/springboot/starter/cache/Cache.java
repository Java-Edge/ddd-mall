

package org.opengoofy.congomall.springboot.starter.cache;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * 缓存接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface Cache {
    
    /**
     * 获取缓存
     */
    <T> T get(@NotBlank String key, Class<T> clazz);
    
    /**
     * 放入缓存
     */
    void put(@NotBlank String key, Object value);
    
    /**
     * 如果 keys 全部不存在，则新增，返回 true，反之 false
     */
    Boolean putIfAllAbsent(@NotNull Collection<String> keys);
    
    /**
     * 删除缓存
     */
    Boolean delete(@NotBlank String key);
    
    /**
     * 删除 keys，返回删除数量
     */
    Long delete(@NotNull Collection<String> keys);
    
    /**
     * 判断 key 是否存在
     */
    Boolean hasKey(@NotBlank String key);
    
    /**
     * 获取缓存组件实例
     */
    Object getInstance();
}
