

package org.opengoofy.congomall.biz.message.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;
import org.opengoofy.congomall.biz.message.domain.repository.MessageSendRepository;
import org.opengoofy.congomall.biz.message.infrastructure.converter.SendMessageConverter;
import org.opengoofy.congomall.biz.message.infrastructure.dao.entity.SendRecordDO;
import org.opengoofy.congomall.biz.message.infrastructure.dao.entity.SendRecordExtendDO;
import org.opengoofy.congomall.biz.message.infrastructure.dao.mapper.SendRecordExtendMapper;
import org.opengoofy.congomall.biz.message.infrastructure.dao.mapper.SendRecordMapper;
import org.opengoofy.congomall.springboot.starter.common.enums.StatusEnum;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

/**
 * 消息发送仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Repository
@AllArgsConstructor
public class MessageSendRepositoryImpl implements MessageSendRepository {
    
    private final SendMessageConverter sendMessageConverter;
    private final SendRecordMapper sendRecordMapper;
    private final SendRecordExtendMapper sendRecordExtendMapper;
    
    @Override
    public void mailMessageSave(MessageSend messageSend) {
        SendRecordDO sendRecordDO = sendMessageConverter.sendMessageUserToDO(messageSend);
        sendRecordDO.setStatus(messageSend.getSendResult() ? StatusEnum.SUCCESS.code() : StatusEnum.FAIL.code());
        sendRecordDO.setSendTime(new Date());
        sendRecordMapper.insert(sendRecordDO);
        SendRecordExtendDO sendRecordExtendDO = SendRecordExtendDO.builder()
                .msgId(messageSend.getMessageSendId())
                .msgParam(Optional.ofNullable(messageSend.getParamList()).map(Object::toString).orElse(null))
                .build();
        sendRecordExtendMapper.insert(sendRecordExtendDO);
    }
}
