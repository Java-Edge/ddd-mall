

package org.opengoofy.congomall.biz.message.infrastructure.dao.mapper;

import org.opengoofy.congomall.biz.message.infrastructure.dao.entity.SendRecordDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息发送记录 Mapper
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper
public interface SendRecordMapper extends BaseMapper<SendRecordDO> {
}
