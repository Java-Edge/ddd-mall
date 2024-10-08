

package org.opengoofy.congomall.biz.customer.user.application.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户收货地址出参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ReceiveAddressRespDTO {
    
    @ApiModelProperty("收货地址 id")
    private String id;
    
    @ApiModelProperty("c端用户 id")
    private String customerUserId;
    
    @ApiModelProperty("收货人名称")
    private String name;
    
    @ApiModelProperty("收货人电话")
    private String phone;
    
    @ApiModelProperty("是否默认 0：否 1：是")
    private Integer defaultFlag;
    
    @ApiModelProperty("标签 0：家 1：公司")
    private Integer tag;
    
    @ApiModelProperty("邮政编码")
    private String postCode;
    
    @ApiModelProperty("省")
    private String province;
    
    @ApiModelProperty("市")
    private String city;
    
    @ApiModelProperty("区")
    private String region;
    
    @ApiModelProperty("详细地址")
    private String detailAddress;
}
