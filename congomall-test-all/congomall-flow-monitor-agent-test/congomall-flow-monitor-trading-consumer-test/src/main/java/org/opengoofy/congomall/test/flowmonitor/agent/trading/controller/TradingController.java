

package org.opengoofy.congomall.test.flowmonitor.agent.trading.controller;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.test.flowmonitor.agent.trading.remote.MessageRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交易控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@AllArgsConstructor
public class TradingController {
    
    private final MessageRemoteService messageRemoteService;
    
    @GetMapping("/api/trading-service/info/{orderId}")
    public String getOrderInfo(@PathVariable("orderId") String orderId) {
        String resultMessageInfo = messageRemoteService.getMessageInfoByOrderId(orderId);
        return resultMessageInfo;
    }
}
