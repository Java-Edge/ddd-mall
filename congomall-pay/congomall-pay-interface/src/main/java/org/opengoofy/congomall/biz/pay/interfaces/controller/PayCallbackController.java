

package org.opengoofy.congomall.biz.pay.interfaces.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.pay.application.convert.PayCallbackRequestConvert;
import org.opengoofy.congomall.biz.pay.application.req.PayCallbackCommand;
import org.opengoofy.congomall.biz.pay.application.service.PayService;
import org.opengoofy.congomall.biz.pay.domain.base.PayCallbackRequest;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 支付结果回调
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@RequiredArgsConstructor
public class PayCallbackController {
    
    private final PayService payService;
    
    @MLog
    @ApiOperation(value = "支付宝回调", notes = "调用支付宝支付后，支付宝会调用此接口发送支付结果")
    @PostMapping("/api/pay-service/callback/alipay")
    public void callbackAlipay(@RequestParam Map<String, Object> requestParam) {
        PayCallbackCommand payCallbackCommand = BeanUtil.mapToBean(requestParam, PayCallbackCommand.class, true, CopyOptions.create());
        payCallbackCommand.setChannel(PayChannelEnum.ALI_PAY.name());
        payCallbackCommand.setOrderRequestId(requestParam.get("out_trade_no").toString());
        payCallbackCommand.setGmtPayment(DateUtil.parse(requestParam.get("gmt_payment").toString()));
        PayCallbackRequest payCallbackRequest = PayCallbackRequestConvert.command2PayCallbackRequest(payCallbackCommand);
        payService.callback(payCallbackRequest);
    }
}
