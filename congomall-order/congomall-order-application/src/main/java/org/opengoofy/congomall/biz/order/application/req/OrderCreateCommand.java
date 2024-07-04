

package org.opengoofy.congomall.biz.order.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单创建
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class OrderCreateCommand {
    
    @ApiModelProperty("用户id")
    private String customerUserId;
    
    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;
    
    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;
    
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;
    
    @ApiModelProperty("订单来源")
    private Integer source;
    
    @ApiModelProperty("订单类型 0：正常订单 1：秒杀订单 2：促销订单")
    private Integer type;
    
    @ApiModelProperty("收货人")
    private String cneeName;
    
    @ApiModelProperty("收货人电话")
    private String cneePhone;
    
    @ApiModelProperty("收货人邮编")
    private String cneePostCode;
    
    @ApiModelProperty("收货人所在省")
    private String cneeProvinc;
    
    @ApiModelProperty("收货人所在市")
    private String cneeCity;
    
    @ApiModelProperty("收货人所在区")
    private String cneeRegion;
    
    @ApiModelProperty("收货人详细地址")
    private String cneeDetailAddress;
    
    @ApiModelProperty("订单备注信息")
    private String remark;
}
