

package org.opengoofy.congomall.biz.order.application.event.order.create;

import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.order.domain.aggregate.OrderProduct;
import org.opengoofy.congomall.biz.order.infrastructure.remote.CartRemoteService;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.CartItemDelReqDTO;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * 清理购物车商品监听
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Order(1)
@Component
@RequiredArgsConstructor
public final class ClearCartProductListener implements ApplicationListener<OrderCreateEvent> {
    
    private final CartRemoteService cartRemoteService;
    
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        CartItemDelReqDTO cartItemDelReqDTO = new CartItemDelReqDTO();
        cartItemDelReqDTO.setCustomerUserId(String.valueOf(event.getOrder().getCustomerUserId()));
        cartItemDelReqDTO.setProductSkuIds(event.getOrder().getOrderProducts().stream().map(OrderProduct::getProductSkuId).map(String::valueOf).collect(Collectors.toList()));
        cartRemoteService.clearCartProduct(cartItemDelReqDTO);
    }
}
