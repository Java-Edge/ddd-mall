

package org.opengoofy.congomall.test.flowmonitor.agent.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients("org.opengoofy.congomall.test.flowmonitor.agent.order.remote")
@SpringBootApplication
public class FlowMonitorOrderConsumer {
    
    public static void main(String[] args) {
        SpringApplication.run(FlowMonitorOrderConsumer.class, args);
    }
}
