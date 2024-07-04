

package org.opengoofy.congomall.biz.order.application.service;

import org.opengoofy.congomall.biz.order.application.req.OrderCreateCommand;
import org.opengoofy.congomall.biz.order.application.req.OrderPageQuery;
import org.opengoofy.congomall.biz.order.application.resp.OrderRespDTO;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;

import java.util.List;

/**
 * 订单接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface OrderService {
    
    /**
     * 创建商品订单
     *
     * @param requestParam 商品订单入参
     * @return 订单号
     */
    String createOrder(OrderCreateCommand requestParam);
    
    /**
     * 查询订单信息
     *
     * @param orderSn 订单号
     * @return 订单基本信息
     */
    OrderRespDTO getOrderByOrderSn(String orderSn);
    
    /**
     * 查询订单信息
     *
     * @param customerUserId 用户 ID
     * @return 用户订单信息集合
     */
    List<OrderRespDTO> getOrderByCustomerUserId(String customerUserId);
    
    /**
     * 取消订单
     *
     * @param orderSn 订单号
     */
    void canalOrder(String orderSn);
    
    /**
     * 删除订单
     *
     * @param orderSn 订单号
     */
    void deleteOrder(String orderSn);
    
    /**
     * 分页查询订单列表
     *
     * @param requestParam 分页查询订单列表入参
     * @return 分页查询订单列表返回数据
     */
    PageResponse<OrderRespDTO> pageQueryOrder(OrderPageQuery requestParam);
}
