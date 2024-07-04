package org.opengoofy.congomall.springboot.starter.swagger;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Knife4j api 地址打印
 */
@Slf4j
@AllArgsConstructor
public class Knife4jDocUrlPrintHandler implements ApplicationRunner {
    
    private final ConfigurableEnvironment environment;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("API Document: http://127.0.0.1:{}{}/doc.html", environment.getProperty("server.port", "8080"), environment.getProperty("server.servlet.context-path", ""));
    }
}