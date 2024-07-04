

package org.opengoofy.congomall.biz.product.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.math.BigDecimal;

/**
 * 商品 SKU
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@TableName("product_sku")
public class ProductSkuDO extends BaseDO {
    
    /**
     * id
     */
    @NonNull
    private Long id;
    
    /**
     * 商品分类id
     */
    private Long categoryId;
    
    /**
     * 商品品牌id
     */
    private Long brandId;
    
    /**
     * 商品id
     */
    private Long productId;
    
    /**
     * 价格
     */
    private BigDecimal price;
    
    /**
     * 库存
     */
    private Integer stock;
    
    /**
     * 锁定库存
     */
    private Integer lockStock;
    
    /**
     * 图片
     */
    private String pic;
    
    /**
     * 属性，json 格式
     */
    private String attribute;
}
