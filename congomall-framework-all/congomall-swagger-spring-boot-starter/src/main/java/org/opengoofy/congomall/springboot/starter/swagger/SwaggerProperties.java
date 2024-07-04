

package org.opengoofy.congomall.springboot.starter.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger 配置
 */
@Data
@ConfigurationProperties("congomall.swagger")
public class SwaggerProperties {
    
    private Boolean enabled;
    
    private String basePackage = "";
    
    private String title = "";
    
    private String groupName = "";
    
    private String description = "";
    
    private String version = "";
    
    private String host = "";
    
    private String license = "";
    
    private String licenseUrl = "";
    
    private String termsOfServiceUrl = "";
    
    private List<String> basePath = new ArrayList();
    
    private List<String> excludePath = new ArrayList();
    
    private Contact contact = new Contact();
    
    private Authorization authorization = new Authorization();
    
    @Data
    @NoArgsConstructor
    public static class Contact {
        
        private String name = "";
        
        private String url = "";
        
        private String email = "";
    }
    
    @Data
    @NoArgsConstructor
    public static class Authorization {
        
        private String name = "";
        
        private String authRegex = "^.*$";
        
        private List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        
        private List<String> tokenUrlList = new ArrayList<>();
    }
    
    @Data
    @NoArgsConstructor
    public static class AuthorizationScope {
        
        private String scope = "";
        
        private String description = "";
    }
}
