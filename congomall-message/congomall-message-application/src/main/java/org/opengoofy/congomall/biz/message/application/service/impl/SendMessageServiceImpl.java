

package org.opengoofy.congomall.biz.message.application.service.impl;

import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.message.application.req.MailSendCommand;
import org.opengoofy.congomall.biz.message.application.resp.MessageSendRespDTO;
import org.opengoofy.congomall.biz.message.application.service.MessageSendService;
import org.opengoofy.congomall.biz.message.domain.common.MessageTypeEnum;
import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;
import org.opengoofy.congomall.biz.message.domain.event.MailMessageSendEvent;
import org.opengoofy.congomall.biz.message.infrastructure.mq.produce.MessageSendProduce;
import org.opengoofy.congomall.springboot.starter.distributedid.SnowflakeIdUtil;
import org.springframework.stereotype.Service;

/**
 * 消息发送
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Service
@AllArgsConstructor
public class SendMessageServiceImpl implements MessageSendService {
    
    private final MessageSendProduce messageSendProduce;
    
    @Override
    public MessageSendRespDTO mailMessageSend(MailSendCommand mailSendCommand) {
        String messageSendId = SnowflakeIdUtil.nextIdStr();
        MessageSend messageSend = MessageSend.builder()
                .title(mailSendCommand.getTitle())
                .sender(mailSendCommand.getSender())
                .receiver(mailSendCommand.getReceiver())
                .cc(mailSendCommand.getCc())
                .paramList(mailSendCommand.getParamList())
                .msgType(MessageTypeEnum.MAIL_MESSAGE.getType())
                .messageSendId(messageSendId)
                .templateId(mailSendCommand.getTemplateId())
                .build();
        messageSendProduce.mailMessageSend(BeanUtil.toBean(messageSend, MailMessageSendEvent.class));
        return new MessageSendRespDTO(messageSendId);
    }
}
