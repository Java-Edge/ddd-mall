

package org.opengoofy.congomall.biz.product.interfaces;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableDynamicThreadPool
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.product")
@MapperScan("org.opengoofy.congomall.biz.product.infrastructure.dao.mapper")
public class ProductApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
