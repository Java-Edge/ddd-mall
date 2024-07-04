

package org.opengoofy.congomall.biz.product.domain.mode;

import lombok.Data;

/**
 * 商品品牌
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductBrand {
    
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
    private String desc;
    
    /**
     * 品牌图
     */
    private String pic;
    
    /**
     * 排序
     */
    private Integer sort;
}
