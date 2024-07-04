

package org.opengoofy.congomall.biz.message.domain.acl;

import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;

/**
 * 邮件发送
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MailMessageProduce {
    
    /**
     * 发送邮件
     *
     * @param messageSend
     * @return
     */
    boolean send(MessageSend messageSend);
}
