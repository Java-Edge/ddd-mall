

package org.opengoofy.congomall.biz.bff.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 极验属性配置
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Component
@ConfigurationProperties(prefix = GeeTestProperties.PREFIX)
public class GeeTestProperties {
    
    public static final String PREFIX = "geetest";
    
    /**
     * 公钥
     */
    private String captchaId;
    
    /**
     * 私钥
     */
    private String privateKey;
}
