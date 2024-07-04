

package org.opengoofy.congomall.biz.product.domain.dto;

import lombok.Data;

/**
 * 商品分类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductCategoryDTO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 分类名称
     */
    private String name;
    
    /**
     * 父级id
     */
    private Long parentId;
    
    /**
     * 层级
     */
    private Integer level;
    
    /**
     * 图标url
     */
    private String iconUrl;
    
    /**
     * 排序
     */
    private Integer sort;
    
    /**
     * 跳转地址
     */
    private String url;
    
    /**
     * 状态 0：展示 1：隐藏
     */
    private Integer status;
}
