

package org.opengoofy.congomall.test.flow.monitor.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FlowMonitorUserProvider {
    
    public static void main(String[] args) {
        SpringApplication.run(FlowMonitorUserProvider.class, args);
    }
}
