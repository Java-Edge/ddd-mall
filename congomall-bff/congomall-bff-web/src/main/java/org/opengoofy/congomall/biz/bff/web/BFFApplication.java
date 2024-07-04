package org.opengoofy.congomall.biz.bff.web;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "org.opengoofy.congomall.bff")
@MapperScan("org.opengoofy.congomall.biz.bff.dao.mapper")
@EnableFeignClients("org.opengoofy.congomall.biz.bff.remote")
@SpringBootApplication(scanBasePackages = "org.opengoofy.congomall.biz.bff")
public class BFFApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BFFApplication.class, args);
    }
}
