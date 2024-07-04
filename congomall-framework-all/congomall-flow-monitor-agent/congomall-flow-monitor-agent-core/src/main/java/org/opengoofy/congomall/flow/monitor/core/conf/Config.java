

package org.opengoofy.congomall.flow.monitor.core.conf;

/**
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class Config {
    
    public static class Agent {
        
        public static final String SPRING_MVC_ENHANCE_CLASS = "org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod";
        public static final String SPRING_MVC_ASPECT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.SpringMvcInstrumentation";
        
        public static final String XXL_JOB_ENHANCE_CLASS = "com.xxl.job.core.handler.impl.MethodJobHandler";
        public static final String XXL_JOB_ASPECT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.XxlJobInstrumentation";
        
        public static final String OPEN_FEIGN_ENHANCE_CLASS = "feign.Client";
        public static final String OPEN_FEIGN_ASPECT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.OpenFeignInstrumentation";
        
        public static final String SPRING_CLOUD_STREAM_ROCKETMQ_PROVIDER_ENHANCE_CLASS = "org.springframework.cloud.stream.messaging.DirectWithAttributesChannel";
        public static final String SPRING_CLOUD_STREAM_ROCKETMQ_PROVIDER_ASPECT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.StreamRocketMQProviderInstrumentation";
        
        public static final String SPRING_CLOUD_STREAM_ROCKETMQ_CONSUMER_ENHANCE_CLASS = "org.springframework.messaging.handler.invocation.InvocableHandlerMethod";
        public static final String SPRING_CLOUD_STREAM_ROCKETMQ_CONSUMER_ASPECT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.StreamRocketMQConsumerInstrumentation";
        
        public static final String SPRING_APPLICATION_ENHANCE_CLASS = "org.springframework.boot.SpringApplication";
        public static final String SPRING_APPLICATION_ASPECT_CLASS = "org.opengoofy.congomall.flow.monitor.plugin.enhancer.SpringApplicationInstrumentation";
    }
    
    public static class Environment {
        
        public static String SPRING_PROFILES_ACTIVE = "";
    }
}
