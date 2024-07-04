

package org.opengoofy.congomall.biz.product.domain.aggregate;

import lombok.*;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

import java.util.List;

/**
 * 商品库存聚合根
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock implements AggregateRoot {
    
    /**
     * 订单号
     */
    private String orderSn;
    
    /**
     * 商品库存详情
     */
    private List<ProductStockDetail> productStockDetails;
}
