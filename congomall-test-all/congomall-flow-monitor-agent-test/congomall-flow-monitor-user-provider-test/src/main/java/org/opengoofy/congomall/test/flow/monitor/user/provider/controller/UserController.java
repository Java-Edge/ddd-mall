

package org.opengoofy.congomall.test.flow.monitor.user.provider.controller;

import com.alibaba.nacos.common.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 用户控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@RestController
public class UserController {
    
    @GetMapping("/api/user-service/info/{orderId}")
    public String getMessageInfoByOrderId(@PathVariable("orderId") String orderId) {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        return orderId;
    }
    
    @GetMapping("/{userId}")
    public String getUserByUserId(@PathVariable(value = "userId") String userId) {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        log.info("================ sleep time: {}", nextInt);
        return userId;
    }
}
