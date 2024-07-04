

package org.opengoofy.congomall.biz.message.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.message.application.req.MailSendCommand;
import org.opengoofy.congomall.biz.message.application.resp.MessageSendRespDTO;
import org.opengoofy.congomall.biz.message.application.service.MessageSendService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 消息发送控制器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@AllArgsConstructor
@Api(tags = "消息发送")
public class MessageSendController {
    
    private final MessageSendService messageSendService;
    
    @MLog
    @PostMapping("/api/message/send/mail")
    @ApiOperation("发送邮箱消息")
    public Result<MessageSendRespDTO> sendMailMessage(@RequestBody @Valid MailSendCommand mailSendCommand) {
        MessageSendRespDTO result = messageSendService.mailMessageSend(mailSendCommand);
        return Results.success(result);
    }
}
