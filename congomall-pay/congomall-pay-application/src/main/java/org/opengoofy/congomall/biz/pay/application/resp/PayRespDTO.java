

package org.opengoofy.congomall.biz.pay.application.resp;

import lombok.Data;

/**
 * 支付返回实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public final class PayRespDTO {
    
    /**
     * 调用支付返回信息
     */
    private String body;
}
