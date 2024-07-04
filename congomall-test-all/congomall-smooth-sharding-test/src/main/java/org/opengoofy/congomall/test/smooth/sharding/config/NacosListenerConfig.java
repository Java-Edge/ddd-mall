

package org.opengoofy.congomall.test.smooth.sharding.config;

import cn.hutool.core.util.BooleanUtil;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 初始化 Nacos 监听
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
public class NacosListenerConfig implements InitializingBean {
    
    @Resource
    private ShardRollbackProperties shardRollbackProperties;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        String serverAddr = "localhost";
        String dataId = "pay-service.properties";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.addListener(dataId, group, new Listener() {
            
            @SneakyThrows
            @Override
            public void receiveConfigInfo(String configInfo) {
                Properties properties = new Properties();
                properties.load(new StringReader(configInfo));
                Object openShard = properties.get("openShard");
                shardRollbackProperties.setOpenShard(BooleanUtil.toBoolean(openShard.toString()));
            }
            
            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }
}
