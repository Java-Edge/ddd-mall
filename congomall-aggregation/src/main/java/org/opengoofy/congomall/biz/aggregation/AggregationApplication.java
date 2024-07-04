package org.opengoofy.congomall.biz.aggregation;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.opengoofy.congomall.biz.customer.user.infrastructure.mq.messaging.UserSink;
import org.opengoofy.congomall.biz.customer.user.infrastructure.mq.messaging.UserSource;
import org.opengoofy.congomall.biz.order.infrastructure.mq.messaging.OrderSink;
import org.opengoofy.congomall.biz.order.infrastructure.mq.messaging.OrderSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableDynamicThreadPool
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "org.opengoofy.congomall.bff")
@MapperScan(value = {
        "org.opengoofy.congomall.biz.*.infrastructure.dao.mapper",
        "org.opengoofy.congomall.biz.customer.user.infrastructure.dao.mapper",
        "org.opengoofy.congomall.biz.bff.dao.mapper"
})
@EnableBinding(value = {
        UserSource.class, UserSink.class, OrderSource.class, OrderSink.class
})
@EnableFeignClients(value = {
        "org.opengoofy.congomall.biz.order.infrastructure.remote",
        "org.opengoofy.congomall.biz.bff.remote",
        "org.opengoofy.congomall.biz.customer.user.infrastructure.remote"
})
@SpringBootApplication(scanBasePackages = {
        "org.opengoofy.congomall",
})
public class AggregationApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AggregationApplication.class, args);
    }
}
