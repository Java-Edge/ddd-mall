

package org.opengoofy.congomall.biz.message.application.service.impl;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.message.application.req.MessageSendQuery;
import org.opengoofy.congomall.biz.message.application.resp.MessageSendQueryRespDTO;
import org.opengoofy.congomall.biz.message.application.service.MessageSendQueryService;
import org.opengoofy.congomall.biz.message.domain.repository.MessageSendQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 消息发送查询
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Service
@AllArgsConstructor
public class SendMessageQueryServiceImpl implements MessageSendQueryService {
    
    private final MessageSendQueryRepository messageSendQueryRepository;
    
    @Override
    public List<MessageSendQueryRespDTO> listMessageSendResult(MessageSendQuery requestParam) {
        org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery messageSendQuery = org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery.builder()
                .receiverList(requestParam.getReceiverList())
                .startTime(requestParam.getStartTime())
                .endTime(requestParam.getEndTime())
                .build();
        List<org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery> result = messageSendQueryRepository.listMessageSendResult(messageSendQuery);
        return org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil.convert(result, MessageSendQueryRespDTO.class);
    }
    
    @Override
    public MessageSendQueryRespDTO getMessageSendResultByMsgId(String messageSendId) {
        org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery messageSendQuery = org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery.builder()
                .messageSendIdList(Lists.newArrayList(Long.parseLong(messageSendId)))
                .build();
        List<org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery> result = messageSendQueryRepository.getMessageSendResultByMsgIds(messageSendQuery);
        return Optional.ofNullable(org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil.convert(result, MessageSendQueryRespDTO.class))
                .map(each -> each.get(0))
                .orElse(null);
    }
}
