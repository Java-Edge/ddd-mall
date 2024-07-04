

package org.opengoofy.congomall.biz.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.biz.order.domain.dto.ProductSkuStockDTO;
import org.opengoofy.congomall.ddd.framework.core.domain.DomainEvent;

import java.util.List;

/**
 * 延迟关闭订单事件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelayCloseOrderEvent implements DomainEvent {
    
    /**
     * 订单号
     */
    private String orderSn;
    
    /**
     * 参与订单的商品 SKU 以及数量，用于回退库存
     */
    private List<ProductSkuStockDTO> productSkuStockList;
}
