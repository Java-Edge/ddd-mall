

package org.opengoofy.congomall.biz.pay.infrastructure.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.pay.domain.aggregate.Pay;
import org.opengoofy.congomall.biz.pay.domain.base.AliPayCallbackRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayCallbackRequest;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;
import org.opengoofy.congomall.biz.pay.domain.repository.PayRepository;
import org.opengoofy.congomall.biz.pay.infrastructure.handler.base.AbstractPayCallbackHandler;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractExecuteStrategy;
import org.springframework.stereotype.Service;

/**
 * 阿里支付回调组件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Service
@RequiredArgsConstructor
public final class AliPayCallbackHandler extends AbstractPayCallbackHandler implements AbstractExecuteStrategy<PayCallbackRequest, Void> {
    
    private final PayRepository payRepository;
    
    @Override
    public void callback(PayCallbackRequest payCallbackRequest) {
        AliPayCallbackRequest aliPayCallBackRequest = payCallbackRequest.getAliPayCallBackRequest();
        Pay payAggregateRoot = Pay.builder()
                .status(aliPayCallBackRequest.getTradeStatus())
                .payAmount(aliPayCallBackRequest.getBuyerPayAmount())
                .tradeNo(aliPayCallBackRequest.getTradeNo())
                .gmtPayment(aliPayCallBackRequest.getGmtPayment())
                .orderRequestId(aliPayCallBackRequest.getOrderRequestId())
                .build();
        payRepository.callbackPay(payAggregateRoot);
    }
    
    @Override
    public String mark() {
        return PayChannelEnum.ALI_PAY.name();
    }
    
    public void execute(PayCallbackRequest requestParam) {
        callback(requestParam);
    }
}
