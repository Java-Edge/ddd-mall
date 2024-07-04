

package org.opengoofy.congomall.biz.product.domain.aggregate;

import lombok.*;
import org.opengoofy.congomall.ddd.framework.core.domain.ValueObject;

/**
 * 商品库存详情
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDetail implements ValueObject {
    
    /**
     * 商品 SPU ID
     */
    private String productId;
    
    /**
     * 商品 SKU ID
     */
    private String productSkuId;
    
    /**
     * 商品数量
     */
    private Integer productQuantity;
}
