

package org.opengoofy.congomall.biz.bff.remote;

import org.opengoofy.congomall.biz.bff.remote.req.CartItemAddReqDTO;
import org.opengoofy.congomall.biz.bff.remote.req.CartItemCheckUpdateReqDTO;
import org.opengoofy.congomall.biz.bff.remote.req.CartItemChecksUpdateReqDTO;
import org.opengoofy.congomall.biz.bff.remote.req.CartItemDelCheckReqDTO;
import org.opengoofy.congomall.biz.bff.remote.req.CartItemDelReqDTO;
import org.opengoofy.congomall.biz.bff.remote.req.CartItemNumUpdateReqDTO;
import org.opengoofy.congomall.biz.bff.remote.resp.CartItemQuerySelectRespDTO;
import org.opengoofy.congomall.biz.bff.remote.resp.CartItemRespDTO;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品购物车远程调用服务
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient(value = "cart-service", url = "${congomall.aggregation.remote-url:}")
public interface ProductCartRemoteService {
    
    /**
     * 分页查询购物车商品
     */
    @GetMapping("/api/cart/product/page")
    Result<PageResponse<CartItemRespDTO>> pageQueryCartItem(@RequestParam("customerUserId") String customerUserId,
                                                            @RequestParam("current") Long current,
                                                            @RequestParam("size") Long size
    );
    
    /**
     * 查询用户选中购物车商品
     */
    @GetMapping("/api/cart/product/{customerUserId}")
    Result<List<CartItemQuerySelectRespDTO>> querySelectCartByCustomerUserId(@PathVariable("customerUserId") String customerUserId);
    
    /**
     * 新增商品到购物车
     */
    @PostMapping("/api/cart/product")
    Result<Void> addCartItem(@RequestBody CartItemAddReqDTO requestParam);
    
    /**
     * 修改购物车商品勾选状态
     */
    @PutMapping("/api/cart/product/check")
    Result<Void> updateCheckCartItem(@RequestBody CartItemCheckUpdateReqDTO requestParam);
    
    /**
     * 修改全部购物车商品勾选状态
     */
    @PutMapping("/api/cart/product/checks")
    Result<Void> updateChecksCartItem(@RequestBody CartItemChecksUpdateReqDTO requestParam);
    
    /**
     * 修改购物车商品SKU数量
     */
    @PutMapping("/api/cart/product/num")
    Result<Void> updateNumCartItem(@RequestBody CartItemNumUpdateReqDTO requestParam);
    
    /**
     * 删除购物车商品
     */
    @DeleteMapping("/api/cart/product")
    Result<Void> clearCartProduct(@RequestBody CartItemDelReqDTO requestParam);
    
    /**
     * 删除选中购物车商品
     */
    @DeleteMapping("/api/cart/product/delete/checks")
    Result<Void> clearCheckCartProduct(@RequestBody CartItemDelCheckReqDTO requestParam);
}
