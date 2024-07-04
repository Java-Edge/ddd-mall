

package org.opengoofy.congomall.biz.product.application.req;

import lombok.Data;
import org.opengoofy.congomall.biz.product.domain.dto.ProductStockDetailDTO;

import java.util.List;

/**
 * 解锁商品库存
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductUnlockStockCommand {
    
    /**
     * 订单号
     */
    private String orderSn;
    
    /**
     * 订单商品详情
     */
    private List<ProductStockDetailDTO> productStockDetails;
}
