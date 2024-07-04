

package org.opengoofy.congomall.biz.bff.web.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.common.ResultT;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.OrderCreateAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.OrderAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.OrderResultAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.handler.CustomBlockHandler;
import org.opengoofy.congomall.biz.bff.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.opengoofy.congomall.biz.bff.common.SentinelLimitFlowConstant.CREATE_ORDER_PATH;

/**
 * 订单控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController("bffOrderController")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService bffOrderService;
    
    @PostMapping("/member/addOrder")
    @ApiOperation(value = "订单创建", notes = "订单创建")
    @SentinelResource(
            value = CREATE_ORDER_PATH,
            blockHandler = "createOrderBlockHandlerMethod",
            blockHandlerClass = CustomBlockHandler.class
    )
    public ResultT<String> addOrder(@RequestBody OrderCreateAdapterReqDTO requestParam) {
        return ResultT.success(bffOrderService.addOrder(requestParam));
    }
    
    @GetMapping("/member/orderList")
    @ApiOperation(value = "订单列表查询", notes = "订单列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "用户商品列表第几页", required = true, example = "1"),
            @ApiImplicitParam(name = "size", value = "用户商品列表每页多少条数据", required = true, example = "10"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, example = "1634554535496892416")
    })
    public ResultT<OrderResultAdapterRespDTO> listOrder(@RequestParam("page") Integer page,
                                                        @RequestParam("size") Integer size,
                                                        @RequestParam("userId") String userId) {
        return ResultT.success(bffOrderService.listOrder(page, size, userId));
    }
    
    @GetMapping("/member/orderDetail")
    @ApiOperation(value = "订单查询", notes = "根据订单号查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, example = "1648278169705656320")
    })
    public ResultT<OrderAdapterRespDTO> getOrderDetail(@RequestParam("orderId") String orderSn) {
        return ResultT.success(bffOrderService.getOrderDetail(orderSn));
    }
    
    @GetMapping("/member/delOrder")
    @ApiOperation(value = "订单删除", notes = "根据订单号删除订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, example = "1648278169705656320")
    })
    public ResultT<Integer> deleteOrder(@RequestParam("orderId") String orderSn) {
        return ResultT.success(bffOrderService.deleteOrder(orderSn));
    }
}
