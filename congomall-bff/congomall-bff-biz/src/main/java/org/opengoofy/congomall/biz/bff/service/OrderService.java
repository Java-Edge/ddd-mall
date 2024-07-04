

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.dto.req.adapter.OrderCreateAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.OrderAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.OrderResultAdapterRespDTO;

/**
 * 订单接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface OrderService {
    
    /**
     * 订单创建
     *
     * @param requestParam 订单创建请求参数
     * @return 订单号
     */
    String addOrder(OrderCreateAdapterReqDTO requestParam);
    
    /**
     * 订单列表查看
     *
     * @param page   当前页
     * @param size   每页多少条
     * @param userId 用户 ID
     * @return 订单列表返回数据
     */
    OrderResultAdapterRespDTO listOrder(Integer page, Integer size, String userId);
    
    /**
     * 根据订单号查询订单详细记录
     *
     * @param orderSn 订单号
     * @return 订单详细返回记录
     */
    OrderAdapterRespDTO getOrderDetail(String orderSn);
    
    /**
     * 根据订单号删除订单
     *
     * @param orderSn 订单号
     * @return 是否删除成功
     */
    Integer deleteOrder(String orderSn);
}
