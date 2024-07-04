

package org.opengoofy.congomall.biz.message.infrastructure.converter;

import org.mapstruct.Mapper;
import org.opengoofy.congomall.biz.message.domain.entity.MessageSend;
import org.opengoofy.congomall.biz.message.infrastructure.dao.entity.SendRecordDO;

/**
 * 消息发送 Entity 转换 DO
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper(componentModel = "spring")
public interface SendMessageConverter {
    
    /**
     * 消息发送 Entity 转换 DO
     *
     * @param messageSend
     * @return
     */
    SendRecordDO sendMessageUserToDO(MessageSend messageSend);
}
