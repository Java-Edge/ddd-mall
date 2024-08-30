package org.opengoofy.congomall.biz.message.application.service;

import org.opengoofy.congomall.biz.message.application.req.MessageSendQuery;
import org.opengoofy.congomall.biz.message.application.resp.MessageSendQueryRespDTO;

import java.util.List;

/**
 * 消息发送查询
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MessageSendQueryService {
    
    /**
     * 根据消息发送时间和接收人集合查询发送结果
     *
     * @param requestParam 消息发送结果查询入参
     * @return 消息发送查询返回结果
     */
    List<MessageSendQueryRespDTO> listMessageSendResult(MessageSendQuery requestParam);
    
    /**
     * 根据消息发送 ID 查询发送结果
     *
     * @param messageSendId 消息发送 ID
     * @return 消息发送查询返回结果
     */
    MessageSendQueryRespDTO getMessageSendResultByMsgId(String messageSendId);
}
