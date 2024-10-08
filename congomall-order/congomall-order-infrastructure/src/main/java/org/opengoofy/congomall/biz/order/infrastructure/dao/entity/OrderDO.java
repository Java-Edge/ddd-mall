

package org.opengoofy.congomall.biz.order.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("order_info")
public class OrderDO extends BaseDO {
    
    /**
     * id
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
     * 收货人
     */
    private String cneeName;
    
    /**
     * 收货人电话
     */
    private String cneePhone;
    
    /**
     * 收货人邮编
     */
    private String cneePostCode;
    
    /**
     * 收货人所在省
     */
    private String cneeProvinc;
    
    /**
     * 收货人所在市
     */
    private String cneeCity;
    
    /**
     * 收货人所在区
     */
    private String cneeRegion;
    
    /**
     * 收货人详细地址
     */
    private String cneeDetailAddress;
    
    /**
     * 收货时间
     */
    private Date receiveTime;
    
    /**
     * 订单备注信息
     */
    private String remark;
    
    /**
     * 收货状态 0：未接收 1：已接收
     */
    private Integer confirmFlag;
    
    /**
     * 发货时间
     */
    private Date deliveryTime;
    
    /**
     * 订单状态
     */
    private Integer status;
}
