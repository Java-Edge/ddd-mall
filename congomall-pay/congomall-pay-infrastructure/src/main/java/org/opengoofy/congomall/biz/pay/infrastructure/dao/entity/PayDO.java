

package org.opengoofy.congomall.biz.pay.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付持久层实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("pay_info")
public class PayDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 订单号
     */
    private String orderSn;
    
    /**
     * 商户订单号
     */
    private String outOrderSn;
    
    /**
     * 支付渠道
     */
    private String channel;
    
    /**
     * 支付环境
     */
    private String tradeType;
    
    /**
     * 订单标题
     */
    private String subject;
    
    /**
     * 交易凭证号
     */
    private String tradeNo;
    
    /**
     * 商户订单号
     * 由商家自定义，64个字符以内，仅支持字母、数字、下划线且需保证在商户端不重复
     */
    private String orderRequestId;
    
    /**
     * 交易总金额
     */
    private BigDecimal totalAmount;
    
    /**
     * 付款时间
     */
    private Date gmtPayment;
    
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    
    /**
     * 支付状态
     */
    private String status;
}
