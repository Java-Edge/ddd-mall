

package org.opengoofy.congomall.biz.pay.infrastructure.handler.base;

import org.opengoofy.congomall.biz.pay.domain.base.PayCallbackRequest;

/**
 * 抽象支付回调组件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public abstract class AbstractPayCallbackHandler {
    
    /**
     * 支付回调抽象接口
     *
     * @param payCallbackRequest 支付回调请求参数
     */
    public abstract void callback(PayCallbackRequest payCallbackRequest);
}
