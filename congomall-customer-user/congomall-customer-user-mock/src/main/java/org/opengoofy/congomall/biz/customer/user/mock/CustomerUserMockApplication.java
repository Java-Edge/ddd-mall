

package org.opengoofy.congomall.biz.customer.user.mock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding({Source.class, Sink.class})
@EnableFeignClients("org.opengoofy.congomall.biz.customer.user.infrastructure.remote")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.customer.user")
@MapperScan("org.opengoofy.congomall.biz.customer.user.infrastructure.dao")
public class CustomerUserMockApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CustomerUserMockApplication.class, args);
    }
}
