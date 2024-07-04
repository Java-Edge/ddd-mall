package org.opengoofy.congomall.springboot.starter.minio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Minio 配置类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ConfigurationProperties(prefix = MinioProperties.PREFIX)
public class MinioProperties {
    
    public static final String PREFIX = "minio";
    
    /**
     * 端点，minio 地址
     */
    private String endpoint;
    
    /**
     * accessKey
     */
    private String accessKey;
    
    /**
     * secretKey
     */
    private String secretKey;
    
    /**
     * bucket
     */
    private String bucket;
}
