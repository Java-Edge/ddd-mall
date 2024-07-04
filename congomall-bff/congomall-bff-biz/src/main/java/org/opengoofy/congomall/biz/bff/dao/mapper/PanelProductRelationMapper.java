

package org.opengoofy.congomall.biz.bff.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.opengoofy.congomall.biz.bff.dao.entity.PanelProductRelationDO;

import java.util.List;

/**
 * 板块商品关联持久层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PanelProductRelationMapper extends BaseMapper<PanelProductRelationDO> {
    
    /**
     * 根据板块 ID 查询关联记录
     */
    List<PanelProductRelationDO> listPanelProductRelationByPanelId(@Param("panelId") Integer panelId);
}
