

package org.opengoofy.congomall.biz.cart.interfaces;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("org.opengoofy.congomall.biz.cart.infrastructure.dao")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.cart")
public class CartApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
