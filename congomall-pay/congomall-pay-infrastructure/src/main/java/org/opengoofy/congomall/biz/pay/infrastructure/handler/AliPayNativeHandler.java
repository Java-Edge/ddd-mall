

package org.opengoofy.congomall.biz.pay.infrastructure.handler;

import cn.hutool.core.text.StrBuilder;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.pay.domain.base.AliPayRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayResponse;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;
import org.opengoofy.congomall.biz.pay.domain.common.PayTradeTypeEnum;
import org.opengoofy.congomall.biz.pay.infrastructure.config.AliPayProperties;
import org.opengoofy.congomall.biz.pay.infrastructure.handler.base.AbstractPayHandler;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractExecuteStrategy;
import org.springframework.stereotype.Service;

/**
 * 阿里支付组件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Service
@RequiredArgsConstructor
public final class AliPayNativeHandler extends AbstractPayHandler implements AbstractExecuteStrategy<PayRequest, PayResponse> {
    
    private final AliPayProperties aliPayProperties;
    
    @SneakyThrows(value = AlipayApiException.class)
    @Override
    public PayResponse pay(PayRequest payRequest) {
        AliPayRequest aliPayRequest = payRequest.getAliPayRequest();
        AlipayConfig alipayConfig = BeanUtil.convert(aliPayProperties, AlipayConfig.class);
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(aliPayRequest.getOrderRequestId());
        model.setTotalAmount(aliPayRequest.getTotalAmount());
        model.setSubject(aliPayRequest.getSubject());
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(aliPayProperties.getNotifyUrl());
        request.setBizModel(model);
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        log.info("发起支付宝支付，订单号：{}，子订单号：{}，订单请求号：{}，订单金额：{} \n调用支付返回：\n\n{}\n",
                aliPayRequest.getOrderSn(),
                aliPayRequest.getOutOrderSn(),
                aliPayRequest.getOrderRequestId(),
                aliPayRequest.getTotalAmount(),
                response.getBody());
        return new PayResponse(response.getBody());
    }
    
    @Override
    public String mark() {
        return StrBuilder.create()
                .append(PayChannelEnum.ALI_PAY.name())
                .append("_")
                .append(PayTradeTypeEnum.NATIVE.name())
                .toString();
    }
    
    @Override
    public PayResponse executeResp(PayRequest requestParam) {
        return pay(requestParam);
    }
}
