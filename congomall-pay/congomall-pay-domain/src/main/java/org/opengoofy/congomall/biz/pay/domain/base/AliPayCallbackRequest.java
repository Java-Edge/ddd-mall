

package org.opengoofy.congomall.biz.pay.domain.base;

import lombok.Data;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付宝回调请求入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public final class AliPayCallbackRequest extends AbstractPayCallbackRequest {
    
    /**
     * 支付渠道
     */
    private String channel;
    
    /**
     * 支付状态
     */
    private String tradeStatus;
    
    /**
     * 支付凭证号
     */
    private String tradeNo;
    
    /**
     * 买家付款时间
     */
    private Date gmtPayment;
    
    /**
     * 买家付款金额
     */
    private BigDecimal buyerPayAmount;
    
    @Override
    public AliPayCallbackRequest getAliPayCallBackRequest() {
        return this;
    }
    
    @Override
    public String buildMark() {
        return PayChannelEnum.ALI_PAY.name();
    }
}
