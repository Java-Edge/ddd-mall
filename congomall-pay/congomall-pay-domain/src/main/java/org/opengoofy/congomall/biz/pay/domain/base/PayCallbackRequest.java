

package org.opengoofy.congomall.biz.pay.domain.base;

/**
 * 支付回调请求入参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PayCallbackRequest {
    
    /**
     * 获取阿里支付回调入参
     */
    AliPayCallbackRequest getAliPayCallBackRequest();
    
    /**
     * 构建查找支付回调策略实现类标识
     */
    String buildMark();
}
