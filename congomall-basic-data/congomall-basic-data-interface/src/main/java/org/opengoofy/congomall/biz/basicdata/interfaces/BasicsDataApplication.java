

package org.opengoofy.congomall.biz.basicdata.interfaces;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.basicdata")
@MapperScan("org.opengoofy.congomall.biz.basicdata.infrastructure.dao.mapper")
public class BasicsDataApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BasicsDataApplication.class, args);
    }
}
