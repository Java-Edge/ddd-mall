

package org.opengoofy.congomall.biz.pay.domain.base;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.opengoofy.congomall.biz.pay.domain.common.PayChannelEnum;

/**
 * 支付宝支付请求入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Accessors(chain = true)
public final class AliPayRequest extends AbstractPayRequest {
    
    /**
     * 商户订单号
     * 由商家自定义，64个字符以内，仅支持字母、数字、下划线且需保证在商户端不重复
     */
    private String outOrderSn;
    
    /**
     * 订单总金额
     * 单位为元，精确到小数点后两位，取值范围：[0.01,100000000]
     */
    private String totalAmount;
    
    /**
     * 订单标题
     * 注意：不可使用特殊字符，如 /，=，& 等
     */
    private String subject;
    
    /**
     * 交易凭证号
     */
    private String tradeNo;
    
    @Override
    public AliPayRequest getAliPayRequest() {
        return this;
    }
    
    @Override
    public String buildMark() {
        String mark = PayChannelEnum.ALI_PAY.name();
        if (StrUtil.isNotBlank(getTradeType())) {
            mark = PayChannelEnum.ALI_PAY.name() + "_" + getTradeType();
        }
        return mark;
    }
}
