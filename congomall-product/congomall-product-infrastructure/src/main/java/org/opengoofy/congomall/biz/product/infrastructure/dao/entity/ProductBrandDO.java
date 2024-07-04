

package org.opengoofy.congomall.biz.product.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

/**
 * 商品品牌
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("product_brand")
public class ProductBrandDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 品牌名称
     */
    private String name;
    
    /**
     * 品牌介绍
     */
    @TableField("`desc`")
    private String desc;
    
    /**
     * 品牌图
     */
    @TableField("`pic`")
    private String pic;
    
    /**
     * 排序
     */
    @TableField("`sort`")
    private Integer sort;
}
