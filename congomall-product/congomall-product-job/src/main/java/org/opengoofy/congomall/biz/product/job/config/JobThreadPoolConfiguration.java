

package org.opengoofy.congomall.biz.product.job.config;

import cn.hippo4j.core.executor.DynamicThreadPool;
import cn.hippo4j.core.executor.support.ThreadPoolBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Configuration
public class JobThreadPoolConfiguration {
    
    @Bean
    @DynamicThreadPool
    public ThreadPoolExecutor productSkuInitSyncThreadPoolExecutor() {
        String productSkuInitSyncThreadPoolId = "product-sku-init-sync-executor";
        return ThreadPoolBuilder.builder()
                .threadPoolId(productSkuInitSyncThreadPoolId)
                .threadFactory(productSkuInitSyncThreadPoolId)
                .dynamicPool()
                .build();
    }
}
