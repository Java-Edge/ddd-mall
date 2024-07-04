

package org.opengoofy.congomall.biz.message.infrastructure.repository;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.message.domain.entity.MessageSendQuery;
import org.opengoofy.congomall.biz.message.domain.repository.MessageSendQueryRepository;
import org.opengoofy.congomall.biz.message.infrastructure.dao.entity.SendRecordDO;
import org.opengoofy.congomall.biz.message.infrastructure.dao.mapper.SendRecordMapper;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 消息发送查询仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Repository
@AllArgsConstructor
public class MessageSendQueryRepositoryImpl implements MessageSendQueryRepository {
    
    private final SendRecordMapper sendRecordMapper;
    
    @Override
    public List<MessageSendQuery> listMessageSendResult(MessageSendQuery messageSendQuery) {
        LambdaQueryWrapper<SendRecordDO> queryWrapper = Wrappers.lambdaQuery(SendRecordDO.class)
                .between(
                        ObjectUtil.isAllNotEmpty(messageSendQuery.getStartTime(), messageSendQuery.getEndTime()),
                        SendRecordDO::getCreateTime, messageSendQuery.getStartTime(),
                        messageSendQuery.getEndTime())
                .in(CollUtil.isNotEmpty(messageSendQuery.getReceiverList()), SendRecordDO::getReceiver, messageSendQuery.getReceiverList());
        List<SendRecordDO> sendRecordDOList = sendRecordMapper.selectList(queryWrapper);
        return BeanUtil.convert(sendRecordDOList, MessageSendQuery.class);
    }
    
    @Override
    public List<MessageSendQuery> getMessageSendResultByMsgIds(MessageSendQuery messageSendQuery) {
        LambdaQueryWrapper<SendRecordDO> queryWrapper = Wrappers.lambdaQuery(SendRecordDO.class)
                .in(CollUtil.isNotEmpty(messageSendQuery.getMessageSendIdList()), SendRecordDO::getMessageSendId, messageSendQuery.getMessageSendIdList());
        List<SendRecordDO> sendRecordDOList = sendRecordMapper.selectList(queryWrapper);
        return BeanUtil.convert(sendRecordDOList, MessageSendQuery.class);
    }
}
