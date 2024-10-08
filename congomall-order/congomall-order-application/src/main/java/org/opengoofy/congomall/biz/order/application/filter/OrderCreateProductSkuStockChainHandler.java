

package org.opengoofy.congomall.biz.order.application.filter;

import cn.hutool.core.collection.CollUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.order.application.filter.base.OrderCreateChainFilter;
import org.opengoofy.congomall.biz.order.application.req.OrderCreateCommand;
import org.opengoofy.congomall.biz.order.domain.common.OrderCreateErrorCodeEnum;
import org.opengoofy.congomall.biz.order.infrastructure.remote.CartRemoteService;
import org.opengoofy.congomall.biz.order.infrastructure.remote.ProductStockRemoteService;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.CartItemQuerySelectRespDTO;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.ProductVerifyStockReqDTO;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.exception.ServiceException;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 订单创建商品 SKU 库存验证
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@RequiredArgsConstructor
public final class OrderCreateProductSkuStockChainHandler implements OrderCreateChainFilter<OrderCreateCommand> {
    
    private final CartRemoteService cartRemoteService;
    
    private final ProductStockRemoteService productStockRemoteService;
    
    @Override
    public void handler(OrderCreateCommand requestParam) {
        List<CartItemQuerySelectRespDTO> actualResultData;
        try {
            Result<List<CartItemQuerySelectRespDTO>> cartProductsResult = cartRemoteService.querySelectCartByCustomerUserId(requestParam.getCustomerUserId());
            actualResultData = Optional.ofNullable(cartProductsResult)
                    .filter(each -> each.isSuccess())
                    .filter(each -> CollUtil.isNotEmpty(each.getData()))
                    .map(each -> each.getData())
                    .orElseThrow(() -> new ServiceException(OrderCreateErrorCodeEnum.PRODUCT_CART_ISNULL_ERROR));
        } catch (Throwable ex) {
            log.error(OrderCreateErrorCodeEnum.PRODUCT_CART_ISNULL_ERROR.message(), ex);
            throw new ServiceException(OrderCreateErrorCodeEnum.PRODUCT_CART_ISNULL_ERROR);
        }
        try {
            Result<Boolean> verifyProductStockResult = productStockRemoteService.verifyProductStock(BeanUtil.convert(actualResultData, ProductVerifyStockReqDTO.class));
            Optional.ofNullable(verifyProductStockResult)
                    .filter(each -> each.isSuccess())
                    .filter(each -> each.getData() != null && each.getData())
                    .orElseThrow(() -> new ServiceException(OrderCreateErrorCodeEnum.PRODUCT_STOCK_VERIFY_ERROR));
        } catch (Throwable ex) {
            log.error(OrderCreateErrorCodeEnum.PRODUCT_STOCK_VERIFY_ERROR.message(), ex);
            throw new ServiceException(OrderCreateErrorCodeEnum.PRODUCT_STOCK_VERIFY_ERROR);
        }
    }
    
    @Override
    public int getOrder() {
        return 2;
    }
}
