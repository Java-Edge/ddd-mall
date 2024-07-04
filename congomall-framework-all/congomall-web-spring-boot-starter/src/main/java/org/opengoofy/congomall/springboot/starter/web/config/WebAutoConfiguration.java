package org.opengoofy.congomall.springboot.starter.web.config;

import org.opengoofy.congomall.springboot.starter.web.GlobalExceptionHandler;
import org.opengoofy.congomall.springboot.starter.web.initialize.InitializeDispatcherServletController;
import org.opengoofy.congomall.springboot.starter.web.initialize.InitializeDispatcherServletHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Web 组件自动装配
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Configuration
public class WebAutoConfiguration {
    
    public final static String INITIALIZE_PATH = "/initialize/dispatcher-servlet";
    
    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler congoMallGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
    
    @Bean
    public InitializeDispatcherServletController initializeDispatcherServletController() {
        return new InitializeDispatcherServletController();
    }
    
    @Bean
    public RestTemplate simpleRestTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }
    
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        return factory;
    }
    
    @Bean
    public InitializeDispatcherServletHandler initializeDispatcherServletHandler(RestTemplate simpleRestTemplate, ConfigurableEnvironment configurableEnvironment) {
        return new InitializeDispatcherServletHandler(simpleRestTemplate, configurableEnvironment);
    }
}
