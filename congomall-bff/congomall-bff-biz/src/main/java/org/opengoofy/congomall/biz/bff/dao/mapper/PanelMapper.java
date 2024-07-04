

package org.opengoofy.congomall.biz.bff.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.opengoofy.congomall.biz.bff.dao.entity.PanelDO;

import java.util.List;

/**
 * 板块持久层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PanelMapper extends BaseMapper<PanelDO> {
    
    /**
     * 查询所有板块记录
     */
    List<PanelDO> listAllPanel();
    
    /**
     * 查询捐赠板块
     */
    PanelDO getThank();
    
    /**
     * 为您推荐板块
     */
    PanelDO getRecommend();
}
