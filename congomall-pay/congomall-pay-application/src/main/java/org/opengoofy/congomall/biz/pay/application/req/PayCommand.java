

package org.opengoofy.congomall.biz.pay.application.req;

import lombok.Data;
import org.opengoofy.congomall.biz.pay.domain.base.AbstractPayRequest;

/**
 * 支付请求命令
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public final class PayCommand extends AbstractPayRequest {
    
    /**
     * 子订单号
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
}
