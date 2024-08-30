package org.opengoofy.congomall.biz.customer.user.infrastructure.remote;

import org.opengoofy.congomall.biz.customer.user.infrastructure.remote.dto.MailSendRemoteCommand;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 消息发送远程服务调用
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient(value = "message-service",url = "${congomall.aggregation.remote-url:}")
public interface MessageSendRemoteService {
    
    /**
     * 邮箱消息发送
     */
    @PostMapping("/api/message/send/mail")
    Result<Void> mailMessageSend(@RequestBody MailSendRemoteCommand mailSendRemoteCommand);
}
