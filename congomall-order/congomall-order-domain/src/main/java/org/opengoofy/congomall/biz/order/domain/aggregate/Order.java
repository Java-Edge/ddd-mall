

package org.opengoofy.congomall.biz.order.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单聚合根
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements AggregateRoot {
    
    /**
     * 订单id
     */
    private Long id;
    
    /**
     * 用户id
     */
    private Long customerUserId;
    
    /**
     * 订单编号
     */
    private String orderSn;
    
    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;
    
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    
    /**
     * 运费金额
     */
    private BigDecimal freightAmount;
    
    /**
     * 支付方式
     */
    private Integer payType;
    
    /**
     * 支付时间
     */
    private Date payTime;
    
    /**
     * 订单来源
     */
    private Integer source;
    
    /**
     * 订单类型 0：正常订单 1：秒杀订单 2：促销订单
     */
    private Integer type;
    
    /**
     * 自动确认天数
     */
    private Integer autoConfirmDay;
    
    /**
     * 物流公司
     */
    private String deliveryCompany;
    
    /**
     * 物流单号
     */
    private String deliverySn;
    
    /**
     * 收货人信息
     */
    private CneeInfo cneeInfo;
    
    /**
     * 订单备注信息
     */
    private String remark;
    
    /**
     * 收货状态 0：未接收 1：已接收
     */
    private Integer confirmFlag;
    
    /**
     * 订单创建时间
     */
    private Date createTime;
    
    /**
     * 发货时间
     */
    private Date deliveryTime;
    
    /**
     * 订单状态
     */
    private Integer status;
    
    /**
     * 订单商品集合
     */
    private List<OrderProduct> orderProducts;
}
