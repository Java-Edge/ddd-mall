package org.opengoofy.congomall.test.flowmonitor.agent.message.provide.rocketmq;

import com.alibaba.nacos.common.utils.ThreadUtils;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 流量治理之 RocketMQ 测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "RocketMQ测试")
public class FlowMonitorSpringCloudStreamRocketMQTest {
    
    private final MessageChannel output;
    
    @GetMapping("/api/message-service/send-mq")
    public String sendMessageTest() {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        Message<?> message = MessageBuilder
                .withPayload("Flow Monitor SpringCloud Stream RocketMQ Test.")
                .build();
        output.send(message);
        log.info("================ Provide sleep time: {}", nextInt);
        return "success";
    }
    
    @StreamListener(Sink.INPUT)
    public void springCloudStreamRocketMQConsumerTest(String param) {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        log.info("================ Consumer sleep time: {}, param: {}", nextInt, param);
        /*
         * if (nextInt % 2 == 0) { throw new RuntimeException(); }
         */
    }
}