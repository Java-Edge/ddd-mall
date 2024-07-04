

package org.opengoofy.congomall.biz.message.domain.repository;

import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;

/**
 * 消息发送仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MessageSendRepository {
    
    /**
     * 邮箱消息发送
     *
     * @param messageSend 邮箱消息发送命令
     * @return 邮箱消息发送返回结果
     */
    void mailMessageSave(MessageSend messageSend);
}
