package org.opengoofy.congomall.test.flowmonitor.agent.message.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding({Source.class, Sink.class})
public class FlowMonitorMessageProvider {
    
    public static void main(String[] args) {
        SpringApplication.run(FlowMonitorMessageProvider.class, args);
    }
}
