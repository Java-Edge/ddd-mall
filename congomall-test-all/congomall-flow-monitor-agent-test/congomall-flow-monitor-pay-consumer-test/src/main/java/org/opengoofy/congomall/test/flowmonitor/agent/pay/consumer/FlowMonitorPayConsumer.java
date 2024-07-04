

package org.opengoofy.congomall.test.flowmonitor.agent.pay.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients("org.opengoofy.congomall.test.flowmonitor.agent.pay.consumer.remote")
@SpringBootApplication
public class FlowMonitorPayConsumer {
    
    public static void main(String[] args) {
        SpringApplication.run(FlowMonitorPayConsumer.class, args);
    }
}
