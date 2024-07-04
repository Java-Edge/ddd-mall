

package org.opengoofy.congomall.biz.product.job;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicThreadPool
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.product")
@MapperScan("org.opengoofy.congomall.biz.product.infrastructure.dao.mapper")
public class ProductJobApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProductJobApplication.class, args);
    }
}
