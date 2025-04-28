

package org.opengoofy.congomall.biz.order.interfaces;

import org.mybatis.spring.annotation.MapperScan;
import org.opengoofy.congomall.biz.order.infrastructure.mq.messaging.OrderSink;
import org.opengoofy.congomall.biz.order.infrastructure.mq.messaging.OrderSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableTransactionManagement(proxyTargetClass = true)
@EnableBinding({OrderSource.class, OrderSink.class})
@EnableFeignClients("org.opengoofy.congomall.biz.order.infrastructure.remote")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.order")
@MapperScan("org.opengoofy.congomall.biz.order.infrastructure.dao")
public class OrderApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
