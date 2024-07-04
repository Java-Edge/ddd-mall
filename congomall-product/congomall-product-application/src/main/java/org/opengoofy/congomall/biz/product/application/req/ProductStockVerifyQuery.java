

package org.opengoofy.congomall.biz.product.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品库存验证
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductStockVerifyQuery {
    
    @ApiModelProperty("商品 id")
    private String productId;
    
    @ApiModelProperty("商品 sku id")
    private String productSkuId;
    
    @ApiModelProperty("商品数量")
    private Integer productQuantity;
}
