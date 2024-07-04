package org.opengoofy.congomall.biz.order.application.filter;

import org.opengoofy.congomall.biz.order.application.filter.base.OrderCreateChainFilter;
import org.opengoofy.congomall.biz.order.application.req.OrderCreateCommand;
import org.opengoofy.congomall.biz.order.domain.common.OrderCreateErrorCodeEnum;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 订单创建参数必填检验
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
public final class OrderCreateParamNotNullChainHandler implements OrderCreateChainFilter<OrderCreateCommand> {
    
    @Override
    public void handler(OrderCreateCommand requestParam) {
        if (Objects.isNull(requestParam.getCustomerUserId())) {
            throw new ClientException(OrderCreateErrorCodeEnum.CUSTOMER_USER_ID_NOTNULL);
        } else if (Objects.isNull(requestParam.getTotalAmount())) {
            throw new ClientException(OrderCreateErrorCodeEnum.TOTAL_AMOUNT_NOTNULL);
        } else if (Objects.isNull(requestParam.getPayAmount())) {
            throw new ClientException(OrderCreateErrorCodeEnum.PAY_AMOUNT_NOTNULL);
        } else if (Objects.isNull(requestParam.getFreightAmount())) {
            throw new ClientException(OrderCreateErrorCodeEnum.FREIGHT_AMOUNT_NOTNULL);
        } else if (Objects.isNull(requestParam.getSource())) {
            throw new ClientException(OrderCreateErrorCodeEnum.SOURCE_NOTNULL);
        }
        // xxx 这里应该把所有订单入参校验必填，因为重复工作量所以暂时验证上述这些
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
}