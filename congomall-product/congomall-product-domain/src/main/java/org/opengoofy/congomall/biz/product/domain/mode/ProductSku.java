

package org.opengoofy.congomall.biz.product.domain.mode;

import lombok.*;

import java.math.BigDecimal;

/**
 * 商品 SKU
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductSku {
    
    /**
     * id
     */
    @NonNull
    private Long id;
    
    /**
     * 商品 id
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
