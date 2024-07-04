

package org.opengoofy.congomall.test.smooth.sharding.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 分片回滚配置类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@RefreshScope
@Data
public class ShardRollbackProperties {
    
    @Value("${openShard:false}")
    private Boolean openShard;
}
