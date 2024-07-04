

package org.opengoofy.congomall.biz.product.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 SPU
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("product_spu")
public class ProductSpuDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品类型id
     */
    private Long categoryId;
    
    /**
     * 商品品牌id
     */
    private Long brandId;
    
    /**
     * 商品名称
     */
    private String name;
    
    /**
     * 商品编码
     */
    private String productSn;
    
    /**
     * 商品主图
     */
    private String pic;
    
    /**
     * 商品图集
     */
    private String photoAlbum;
    
    /**
     * 商品价格
     */
    private BigDecimal price;
    
    /**
     * 促销价格
     */
    private BigDecimal promotionPrice;
    
    /**
     * 促销开始时间
     */
    private Date promotionStartTime;
    
    /**
     * 促销结束时间
     */
    private Date promotionEndTime;
    
    /**
     * 副标题
     */
    private String subTitle;
    
    /**
     * 销量
     */
    private Integer sales;
    
    /**
     * 单位
     */
    private String unit;
    
    /**
     * 商品详情
     */
    private String detail;
    
    /**
     * 发布状态 0：发布 1：未发布
     */
    private Integer publishStatus;
    
    /**
     * 新品状态 0：新品 1：非新品
     */
    private Integer newStatus;
    
    /**
     * 推荐状态 0：推荐 1：非推荐
     */
    private Integer recommandStatus;
}
