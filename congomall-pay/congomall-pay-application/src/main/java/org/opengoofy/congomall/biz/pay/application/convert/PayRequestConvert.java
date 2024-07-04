

package org.opengoofy.congomall.biz.pay.application.convert;

import org.opengoofy.congomall.biz.pay.application.req.PayCommand;
import org.opengoofy.congomall.biz.pay.domain.base.AliPayRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayRequest;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;

import java.util.Objects;

/**
 * 支付请求入参转换器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class PayRequestConvert {
    
    /**
     * {@link PayCommand} to {@link PayRequest}
     *
     * @param payCommand 支付请求参数
     * @return {@link PayRequest}
     */
    public static PayRequest command2PayRequest(PayCommand payCommand) {
        PayRequest payRequest = null;
        if (Objects.equals(payCommand.getChannel(), PayChannelEnum.ALI_PAY.name())) {
            payRequest = BeanUtil.convert(payCommand, AliPayRequest.class);
        }
        return payRequest;
    }
}
