

package org.opengoofy.congomall.biz.bff.remote.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 修改收货地址
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ApiModel("新增收货地址")
public class ReceiveAddressUpdateCommand {
    
    /**
     * 收货地址id
     */
    private String id;
    
    /**
     * c端用户id
     */
    private String customerUserId;
    
    /**
     * 收货人名称
     */
    private String name;
    
    /**
     * 收货人电话
     */
    private String phone;
    
    /**
     * 是否默认 0：否 1：是
     */
    private Integer defaultFlag;
    
    /**
     * 标签 0：家 1：公司
     */
    private Integer tag;
    
    /**
     * 邮政编码
     */
    private String postCode;
    
    /**
     * 省
     */
    private String province;
    
    /**
     * 市
     */
    private String city;
    
    /**
     * 区
     */
    private String region;
    
    /**
     * 详细地址
     */
    private String detailAddress;
}
