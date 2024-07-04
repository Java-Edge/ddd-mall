

package org.opengoofy.congomall.biz.cart.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 删除购物车入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CartItemDelReqDTO {
    
    @ApiModelProperty("用户ID")
    private String customerUserId;
    
    @ApiModelProperty("商品SKU集合")
    private List<String> productSkuIds;
}
