

package org.opengoofy.congomall.biz.order.infrastructure.remote;

import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.CartItemDelReqDTO;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.CartItemQuerySelectRespDTO;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 购物车远程调用
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient(value = "cart-service", url = "${congomall.aggregation.remote-url:}")
public interface CartRemoteService {
    
    /**
     * 根据用户ID查询选中状态购物车商品
     */
    @GetMapping("/api/cart/product/{customer_user_id}")
    Result<List<CartItemQuerySelectRespDTO>> querySelectCartByCustomerUserId(@PathVariable("customer_user_id") String customerUserId);
    
    /**
     * 删除购物车商品
     */
    @DeleteMapping("/api/cart/product")
    Result<Void> clearCartProduct(@RequestBody CartItemDelReqDTO requestParam);
}
