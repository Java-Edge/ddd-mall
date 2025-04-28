

package org.opengoofy.congomall.biz.customer.user.web;

import org.mybatis.spring.annotation.MapperScan;
import org.opengoofy.congomall.biz.customer.user.infrastructure.mq.messaging.UserSink;
import org.opengoofy.congomall.biz.customer.user.infrastructure.mq.messaging.UserSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableDiscoveryClient
@EnableBinding({UserSource.class, UserSink.class})
@EnableFeignClients("org.opengoofy.congomall.biz.customer.user.infrastructure.remote")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.customer.user")
@MapperScan("org.opengoofy.congomall.biz.customer.user.infrastructure.dao")
public class CustomerUserApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CustomerUserApplication.class, args);
    }
}
