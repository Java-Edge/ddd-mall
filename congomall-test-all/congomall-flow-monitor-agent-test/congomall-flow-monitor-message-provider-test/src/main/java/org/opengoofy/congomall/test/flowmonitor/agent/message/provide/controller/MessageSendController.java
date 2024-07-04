

package org.opengoofy.congomall.test.flowmonitor.agent.message.provide.controller;

import com.alibaba.nacos.common.utils.ThreadUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 消息发送控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@RestController
@Api(tags = "消息发送")
public class MessageSendController {
    
    @GetMapping("/api/message-service/info/{orderId}")
    public String getMessageInfoByOrderId(@PathVariable("orderId") String orderId) {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        if (nextInt % 2 == 0) {
            throw new RuntimeException();
        }
        log.info("================ sleep time: {}", nextInt);
        return orderId;
    }
    
    @GetMapping("/api/message-service/details")
    public String getMessageDetails(@RequestParam(value = "orderId", required = false) String orderId) {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        if (nextInt % 2 == 0) {
            throw new RuntimeException();
        }
        return orderId;
    }
}
