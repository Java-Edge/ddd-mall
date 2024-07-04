

package org.opengoofy.congomall.biz.order.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.opengoofy.congomall.ddd.framework.core.domain.Entity;

import java.math.BigDecimal;

/**
 * 订单商品
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderProduct implements Entity {
    
    /**
     * 订单id
     */
    private Long orderId;
    
    /**
     * 订单编号
     */
    private String orderSn;
    
    /**
     * 商品 SPU ID
     */
    private Long productId;
    
    /**
     * 商品 SKU ID
     */
    private Long productSkuId;
    
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
     * 商品购买数量
     */
    private Integer productQuantity;
    
    /**
     * 规格，json 格式
     */
    private String productAttribute;
}
