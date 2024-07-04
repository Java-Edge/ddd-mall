

package org.opengoofy.congomall.biz.message.infrastructure.facade;

import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.message.domain.acl.MailMessageProduce;
import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;
import org.opengoofy.congomall.biz.message.domain.repository.MessageSendRepository;
import org.springframework.stereotype.Component;

/**
 * 邮件消息发送外观
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@RequiredArgsConstructor
public final class MessageSendFacade {
    
    private final MessageSendRepository messageSendRepository;
    
    private final MailMessageProduce mailMessageProduce;
    
    /**
     * 邮箱消息发送
     *
     * @param messageSend 消息发送实体
     */
    public void mailMessageSend(MessageSend messageSend) {
        boolean sendResult = mailMessageProduce.send(messageSend);
        messageSend.setSendResult(sendResult);
        messageSendRepository.mailMessageSave(messageSend);
    }
}
