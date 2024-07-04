

package org.opengoofy.congomall.biz.pay.domain.base;

/**
 * 支付入参接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PayRequest {
    
    /**
     * 获取阿里支付入参
     */
    AliPayRequest getAliPayRequest();
    
    /**
     * 商户订单号
     * 由商家自定义，64个字符以内，仅支持字母、数字、下划线且需保证在商户端不重复
     * 默认雪花算法生成，不同支付方式如需扩展自定义重写即可
     */
    String getOrderRequestId();
    
    /**
     * 构建查找支付策略实现类标识
     */
    String buildMark();
}
