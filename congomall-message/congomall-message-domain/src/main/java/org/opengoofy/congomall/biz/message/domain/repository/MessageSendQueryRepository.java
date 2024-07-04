

package org.opengoofy.congomall.biz.message.domain.repository;

import org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery;

import java.util.List;

/**
 * 消息发送查询仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MessageSendQueryRepository {
    
    /**
     * 根据消息发送时间和接收人集合查询发送结果
     *
     * @param messageSendQuery 消息发送结果查询入参
     * @return 消息发送查询返回结果
     */
    List<MessageSendQuery> listMessageSendResult(MessageSendQuery messageSendQuery);
    
    /**
     * 根据消息发送 ID 查询发送结果
     *
     * @param messageSendQuery 消息发送结果查询入参
     * @return 消息发送查询返回结果
     */
    List<MessageSendQuery> getMessageSendResultByMsgIds(MessageSendQuery messageSendQuery);
}
