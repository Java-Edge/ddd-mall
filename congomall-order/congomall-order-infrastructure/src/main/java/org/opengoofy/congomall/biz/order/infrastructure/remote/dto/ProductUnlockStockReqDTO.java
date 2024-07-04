

package org.opengoofy.congomall.biz.order.infrastructure.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 解锁商品库存
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUnlockStockReqDTO {
    
    /**
     * 订单号
     */
    private String orderSn;
    
    /**
     * 订单商品详情
     */
    private List<ProductStockDetailReqDTO> productStockDetails;
}
