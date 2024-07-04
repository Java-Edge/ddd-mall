

package org.opengoofy.congomall.biz.cart.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements AggregateRoot {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品 spu id
     */
    private Long productId;
    
    /**
     * 商品 sku id
     */
    private Long productSkuId;
    
    /**
     * c 端用户 id
     */
    private Long customerUserId;
    
    /**
     * 商品图
     */
    private String productPic;
    
    /**
     * 商品名称
     */
    private String productName;
    
    /**
     * 商品品牌
     */
    private String productBrand;
    
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    
    /**
     * 加购物车数量
     */
    private Integer productQuantity;
    
    /**
     * 商品规格，json 格式
     */
    private String productAttribute;
    
    /**
     * 选中标志
     */
    private Integer selectFlag;
    
    /**
     * 商品 sku ids
     */
    private List<String> productSkuIds;
}
