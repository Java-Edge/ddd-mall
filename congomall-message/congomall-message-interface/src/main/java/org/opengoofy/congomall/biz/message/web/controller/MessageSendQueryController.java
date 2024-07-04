

package org.opengoofy.congomall.biz.message.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.message.application.req.MessageSendQuery;
import org.opengoofy.congomall.biz.message.application.resp.MessageSendQueryRespDTO;
import org.opengoofy.congomall.biz.message.application.service.MessageSendQueryService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息发送查询控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@AllArgsConstructor
@Api(tags = "消息发送查询")
public class MessageSendQueryController {
    
    private final MessageSendQueryService messageSendQueryService;
    
    @PostMapping("/api/message/result")
    @ApiOperation(value = "查询消息发送结果", notes = "根据消息发送时间和接收人集合查询发送结果")
    public Result<List<MessageSendQueryRespDTO>> listMessageSendResult(@RequestBody MessageSendQuery requestParam) {
        List<MessageSendQueryRespDTO> result = messageSendQueryService.listMessageSendResult(requestParam);
        return Results.success(result);
    }
    
    @GetMapping("/api/message/result/{messageSendId}")
    @ApiOperation(value = "查询消息发送结果", notes = "根据消息发送ID查询发送结果")
    public Result<MessageSendQueryRespDTO> getMessageSendResultByMsgId(@PathVariable("messageSendId") String messageSendId) {
        MessageSendQueryRespDTO result = messageSendQueryService.getMessageSendResultByMsgId(messageSendId);
        return Results.success(result);
    }
}
