package org.opengoofy.congomall.springboot.starter.swagger;

import com.github.xiaoymin.knife4j.core.util.StrUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Swagger 自动装配
 */
@EnableOpenApi
@Profile({"dev", "local", "test"})
@ConditionalOnProperty(name = "congomall.swagger.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerAutoConfiguration {
    
    @Bean
    public Docket docketApi(SwaggerProperties swaggerProperties) {
        List<Predicate<String>> excludePath = new ArrayList<>();
        swaggerProperties.getExcludePath().forEach(path -> excludePath.add(PathSelectors.ant(path)));
        Docket defaultDocket = new Docket(DocumentationType.OAS_30)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo(swaggerProperties)).select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.regex("/error.*").negate())
                .paths(PathSelectors.regex("/initialize/dispatcher-servlet").negate())
                .paths(PathSelectors.regex("/actuator.*").negate())
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Collections.singletonList(securityContext(swaggerProperties)));
        String groupName = swaggerProperties.getGroupName();
        if (StrUtil.isNotBlank(groupName)) {
            defaultDocket.groupName(groupName);
        }
        return defaultDocket;
    }
    
    private SecurityContext securityContext(SwaggerProperties swaggerProperties) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth(swaggerProperties))
                .build();
    }
    
    private List<SecurityReference> defaultAuth(SwaggerProperties swaggerProperties) {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        swaggerProperties.getAuthorization().getAuthorizationScopeList()
                .forEach(authorizationScope -> authorizationScopeList.add(new AuthorizationScope(authorizationScope.getScope(), authorizationScope.getDescription())));
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[authorizationScopeList.size()];
        return Collections.singletonList(SecurityReference.builder()
                .reference(swaggerProperties.getAuthorization().getName())
                .scopes(authorizationScopeList.toArray(authorizationScopes))
                .build());
    }
    
    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }
    
    @Bean
    public Knife4jDocUrlPrintHandler knife4jDocUrlPrintHandler(ConfigurableEnvironment environment) {
        return new Knife4jDocUrlPrintHandler(environment);
    }
}
