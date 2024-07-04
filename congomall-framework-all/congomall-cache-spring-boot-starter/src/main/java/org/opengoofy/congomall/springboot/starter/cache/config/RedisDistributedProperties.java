

package org.opengoofy.congomall.springboot.starter.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * 分布式缓存配置
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ConfigurationProperties(prefix = RedisDistributedProperties.PREFIX)
public class RedisDistributedProperties {
    
    public static final String PREFIX = "congomall.cache.redis";
    
    /**
     * Key 前缀
     */
    private String prefix = "";
    
    /**
     * Key 前缀字符集
     */
    private String prefixCharset = "UTF-8";
    
    /**
     * 默认超时时间
     */
    private Long valueTimeout = 30000L;
    
    /**
     * 时间单位
     */
    private TimeUnit valueTimeUnit = TimeUnit.MILLISECONDS;
}
