

package org.opengoofy.congomall.test.flowmonitor.agent.order.controller;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.test.flowmonitor.agent.order.remote.MessageRemoteService;
import org.opengoofy.congomall.test.flowmonitor.agent.order.remote.UserRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@AllArgsConstructor
public class OrderController {
    
    private final MessageRemoteService messageRemoteService;
    
    private final UserRemoteService userRemoteService;
    
    @GetMapping("/api/order-service/info/{orderId}")
    public String getOrderInfo(@PathVariable("orderId") String orderId) {
        String resultMessageInfo = messageRemoteService.getMessageInfoByOrderId(orderId);
        return resultMessageInfo;
    }
    
    @GetMapping("/api/order-service/user/info/{orderId}")
    public String getUserInfoByOrderId(@PathVariable("orderId") String orderId) {
        String resultUserInfo = userRemoteService.getUserInfoByOrderId(orderId);
        return resultUserInfo;
    }
}
