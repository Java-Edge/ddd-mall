package org.opengoofy.congomall.biz.message.web;

import org.mybatis.spring.annotation.MapperScan;
import org.opengoofy.congomall.biz.message.infrastructure.mq.messaging.MessageSink;
import org.opengoofy.congomall.biz.message.infrastructure.mq.messaging.MessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableDiscoveryClient
@EnableBinding({MessageSource.class, MessageSink.class})
@MapperScan("org.opengoofy.congomall.biz.message.infrastructure.dao")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.message")
public class MessageApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}
