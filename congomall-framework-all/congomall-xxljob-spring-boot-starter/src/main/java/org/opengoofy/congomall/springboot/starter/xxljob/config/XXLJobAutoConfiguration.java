package org.opengoofy.congomall.springboot.starter.xxljob.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * XXL-Job 自动装配
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class XXLJobAutoConfiguration {
    
    @Value("${xxl-job.admin.addresses}")
    private String adminAddresses;
    
    @Value("${xxl-job.accessToken}")
    private String accessToken;
    
    @Value("${xxl-job.executor.appname}")
    private String appname;
    
    @Value("${xxl-job.executor.ip}")
    private String ip;
    
    @Value("${xxl-job.executor.port}")
    private int port;
    
    @Value("${xxl-job.executor.logpath}")
    private String logPath;
    
    @Value("${xxl-job.executor.logretentiondays}")
    private int logRetentionDays;
    
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }
}