

package org.opengoofy.congomall.biz.order.application.event.order.create;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.order.infrastructure.remote.ProductStockRemoteService;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.ProductLockStockReqDTO;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.ProductStockDetailReqDTO;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.exception.ServiceException;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 锁定商品库存监听
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@Order(2)
@RequiredArgsConstructor
public final class LockProductStockListener implements ApplicationListener<OrderCreateEvent> {
    
    private final ProductStockRemoteService productStockRemoteService;
    
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        ProductLockStockReqDTO requestParam = ProductLockStockReqDTO.builder()
                .orderSn(event.getOrder().getOrderSn())
                .productStockDetails(BeanUtil.convert(event.getOrder().getOrderProducts(), ProductStockDetailReqDTO.class))
                .build();
        try {
            Result<Boolean> lockProductStockResult = productStockRemoteService.lockProductStock(requestParam);
            if (!lockProductStockResult.isSuccess() || !lockProductStockResult.getData()) {
                throw new ServiceException(lockProductStockResult.getMessage());
            }
        } catch (Throwable ex) {
            log.error("锁定商品库存失败, 入参: {}", JSON.toJSONString(requestParam), ex);
            throw ex;
        }
    }
}
