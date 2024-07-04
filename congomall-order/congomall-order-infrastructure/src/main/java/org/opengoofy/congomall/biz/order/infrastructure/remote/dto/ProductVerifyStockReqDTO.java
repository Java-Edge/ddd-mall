

package org.opengoofy.congomall.biz.order.infrastructure.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验证商品库存
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVerifyStockReqDTO {
    
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
