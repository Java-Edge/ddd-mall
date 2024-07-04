

package org.opengoofy.congomall.biz.pay.application.convert;

import org.opengoofy.congomall.biz.pay.application.req.PayCallbackCommand;
import org.opengoofy.congomall.biz.pay.domain.base.AliPayCallbackRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayCallbackRequest;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;

import java.util.Objects;

/**
 * 支付回调请求入参转换器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class PayCallbackRequestConvert {
    
    /**
     * {@link PayCallbackCommand} to {@link PayCallbackRequest}
     *
     * @param payCallbackCommand 支付回调请求参数
     * @return {@link PayCallbackRequest}
     */
    public static PayCallbackRequest command2PayCallbackRequest(PayCallbackCommand payCallbackCommand) {
        PayCallbackRequest payCallbackRequest = null;
        if (Objects.equals(payCallbackCommand.getChannel(), PayChannelEnum.ALI_PAY.name())) {
            payCallbackRequest = BeanUtil.convert(payCallbackCommand, AliPayCallbackRequest.class);
            ((AliPayCallbackRequest) payCallbackRequest).setOrderRequestId(payCallbackCommand.getOrderRequestId());
        }
        return payCallbackRequest;
    }
}
