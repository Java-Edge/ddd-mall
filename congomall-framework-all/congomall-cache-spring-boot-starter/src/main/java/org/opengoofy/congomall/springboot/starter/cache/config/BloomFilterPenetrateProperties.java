

package org.opengoofy.congomall.springboot.starter.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 缓存穿透布隆过滤器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ConfigurationProperties(prefix = BloomFilterPenetrateProperties.PREFIX)
public class BloomFilterPenetrateProperties {
    
    public static final String PREFIX = "congomall.cache.redis.bloom-filter.default";
    
    /**
     * 布隆过滤器默认实例名称
     */
    private String name = "cache_penetration_bloom_filter";
    
    /**
     * 每个元素的预期插入量
     */
    private Long expectedInsertions = 64000L;
    
    /**
     * 预期错误概率
     */
    private Double falseProbability = 0.03D;
}
