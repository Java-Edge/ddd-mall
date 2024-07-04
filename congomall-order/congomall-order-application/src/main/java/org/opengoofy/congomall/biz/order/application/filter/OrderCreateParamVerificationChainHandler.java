

package org.opengoofy.congomall.biz.order.application.filter;

import org.opengoofy.congomall.biz.order.application.filter.base.OrderCreateChainFilter;
import org.opengoofy.congomall.biz.order.application.req.OrderCreateCommand;
import org.opengoofy.congomall.biz.order.domain.common.OrderCreateErrorCodeEnum;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 订单创建参数正确性检验
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
public final class OrderCreateParamVerificationChainHandler implements OrderCreateChainFilter<OrderCreateCommand> {
    
    @Override
    public void handler(OrderCreateCommand requestParam) {
        if (requestParam.getTotalAmount().compareTo(new BigDecimal(0)) == -1 || requestParam.getTotalAmount().compareTo(new BigDecimal(0)) == 0) {
            throw new ClientException(OrderCreateErrorCodeEnum.TOTAL_AMOUNT_ERROR);
        } else if (requestParam.getPayAmount().compareTo(new BigDecimal(0)) == -1 || requestParam.getPayAmount().compareTo(new BigDecimal(0)) == 0) {
            throw new ClientException(OrderCreateErrorCodeEnum.PAY_AMOUNT_ERROR);
        } else if (requestParam.getFreightAmount().compareTo(new BigDecimal(0)) == -1) {
            throw new ClientException(OrderCreateErrorCodeEnum.FREIGHT_AMOUNT_ERROR);
        } else if (requestParam.getTotalAmount().compareTo(requestParam.getPayAmount()) == -1) {
            throw new ClientException(OrderCreateErrorCodeEnum.AMOUNT_VERIFICATION_ERROR);
        }
        // xxx 还有更多订单参数信息需要验证，因为重复工作量所以暂时验证上述这些
    }
    
    @Override
    public int getOrder() {
        return 1;
    }
}
