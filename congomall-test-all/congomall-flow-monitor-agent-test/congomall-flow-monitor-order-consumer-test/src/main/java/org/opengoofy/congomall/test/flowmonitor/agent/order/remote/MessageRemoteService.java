

package org.opengoofy.congomall.test.flowmonitor.agent.order.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 消息远程调用接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient("flow-monitor-message-provider-test")
public interface MessageRemoteService {
    
    /**
     * 获取用户信息
     */
    @GetMapping("/api/message-service/info/{orderId}")
    String getMessageInfoByOrderId(@PathVariable("orderId") String orderId);
}
