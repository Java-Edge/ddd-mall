

package org.opengoofy.congomall.biz.cart.domain.repository;

import org.opengoofy.congomall.biz.cart.domain.aggregate.CartItem;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;

import java.util.List;

/**
 * 购物车仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface CartItemRepository {
    
    /**
     * 分页查询购物车商品
     *
     * @param customerUserId 用户 ID
     * @param pageRequest    分页请求对象
     * @return 购物车商品分页返回数据
     */
    PageResponse<CartItem> pageQueryCartItem(String customerUserId, PageRequest pageRequest);
    
    /**
     * 查询用户选中购物车商品
     *
     * @param customerUserId 用户 ID
     * @return 购物车商品集合
     */
    List<CartItem> querySelectCartByCustomerUserId(String customerUserId);
    
    /**
     * 新增商品到购物车
     *
     * @param cartItem 购物车聚合根
     */
    void addCartItem(CartItem cartItem);
    
    /**
     * 修改购物车商品勾选状态
     *
     * @param cartItem 购物车聚合根
     */
    void updateCheckCartItem(CartItem cartItem);
    
    /**
     * 修改全部购物车商品勾选状态
     *
     * @param cartItem 购物车聚合根
     */
    void updateChecksCartItem(CartItem cartItem);
    
    /**
     * 修改购物车商品
     *
     * @param cartItem 购物车聚合根
     */
    void updateCartItem(CartItem cartItem);
    
    /**
     * 删除购物车商品
     *
     * @param cartItem 购物车聚合根
     */
    void deleteCartItem(CartItem cartItem);
    
    /**
     * 统计用户购物车商品数量
     *
     * @param customerUserId 用户 ID
     * @return 统计购物车商品数量
     */
    int countUserCartItem(String customerUserId);
    
    /**
     * 删除选中购物车商品
     *
     * @param cartItem 购物车聚合根
     */
    void deleteChecksCartItem(CartItem cartItem);
}
