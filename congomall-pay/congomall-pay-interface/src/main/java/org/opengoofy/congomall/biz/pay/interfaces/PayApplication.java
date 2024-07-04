

package org.opengoofy.congomall.biz.pay.interfaces;

import org.mybatis.spring.annotation.MapperScan;
import org.opengoofy.congomall.biz.pay.infrastructure.mq.messaging.PaySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(PaySource.class)
@MapperScan("org.opengoofy.congomall.biz.pay.infrastructure.dao")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.pay")
public class PayApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
