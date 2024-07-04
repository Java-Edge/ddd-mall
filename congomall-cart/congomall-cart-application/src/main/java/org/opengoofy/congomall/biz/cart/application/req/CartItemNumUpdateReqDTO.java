

package org.opengoofy.congomall.biz.cart.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修改购物车商品SKU数量入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CartItemNumUpdateReqDTO {
    
    @ApiModelProperty("商品id")
    private String productId;
    
    @ApiModelProperty("商品sku id")
    private String productSkuId;
    
    @ApiModelProperty("用户id")
    private String customerUserId;
    
    @ApiModelProperty("加购物车数量")
    private Integer productQuantity;
}
