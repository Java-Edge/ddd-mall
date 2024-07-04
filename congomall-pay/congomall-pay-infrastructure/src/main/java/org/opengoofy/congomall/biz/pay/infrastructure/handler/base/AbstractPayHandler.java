

package org.opengoofy.congomall.biz.pay.infrastructure.handler.base;

import org.opengoofy.congomall.biz.pay.domain.base.PayRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayResponse;

/**
 * 抽象支付组件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public abstract class AbstractPayHandler {
    
    /**
     * 支付抽象接口
     *
     * @param payRequest 支付请求参数
     * @return 支付响应参数
     */
    public abstract PayResponse pay(PayRequest payRequest);
}
