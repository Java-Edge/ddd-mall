

package org.opengoofy.congomall.biz.pay.application.service;

import org.opengoofy.congomall.biz.pay.application.resp.PayRespDTO;
import org.opengoofy.congomall.biz.pay.domain.base.PayCallbackRequest;
import org.opengoofy.congomall.biz.pay.domain.base.PayRequest;

/**
 * 支付接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface PayService {
    
    /**
     * 公共支付，对接支付宝、微信等常用支付方式
     *
     * @param requestParam 支付请求入参
     * @return 支付返回结果
     */
    PayRespDTO commonPay(PayRequest requestParam);
    
    /**
     * 对接三方支付平台支付结果回调
     *
     * @param requestParam 支付回调请求入参
     */
    void callback(PayCallbackRequest requestParam);
}
