

package org.opengoofy.congomall.biz.pay.domain.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽象支付回调入参实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public abstract class AbstractPayCallbackRequest implements PayCallbackRequest {
    
    @Getter
    @Setter
    private String orderRequestId;
    
    @Override
    public AliPayCallbackRequest getAliPayCallBackRequest() {
        return null;
    }
    
    @Override
    public String buildMark() {
        return null;
    }
}
