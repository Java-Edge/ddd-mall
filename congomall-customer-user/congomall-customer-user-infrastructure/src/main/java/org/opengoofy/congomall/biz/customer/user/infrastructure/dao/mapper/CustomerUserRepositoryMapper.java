

package org.opengoofy.congomall.biz.customer.user.infrastructure.dao.mapper;

import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity.CustomerUserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * C 端用户
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper
public interface CustomerUserRepositoryMapper extends BaseMapper<CustomerUserDO> {
}
