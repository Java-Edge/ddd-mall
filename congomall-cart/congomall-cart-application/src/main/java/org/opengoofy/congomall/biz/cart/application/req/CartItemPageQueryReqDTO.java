

package org.opengoofy.congomall.biz.cart.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;

/**
 * 分页查询购物车入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CartItemPageQueryReqDTO extends PageRequest {
    
    @ApiModelProperty("c 端用户 id")
    private String customerUserId;
}
