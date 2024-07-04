

package org.opengoofy.congomall.biz.bff.remote.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除选中购物车商品入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CartItemDelCheckReqDTO {
    
    @ApiModelProperty("用户ID")
    private String customerUserId;
}
