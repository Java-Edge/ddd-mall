

package org.opengoofy.congomall.biz.bff.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

/**
 * 板块商品关联实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("panel_product_relation")
public class PanelProductRelationDO extends BaseDO {
    
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 板块id
     */
    private Long panelId;
    
    /**
     * 商品id
     */
    private Long productId;
    
    /**
     * 商品大图
     */
    private String bigPic;
    
    /**
     * 商品图
     */
    private String pic;
    
    /**
     * 排序
     */
    private Integer sort;
}
