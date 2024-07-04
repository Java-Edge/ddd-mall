

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.Data;

/**
 * 订单地址适配返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class OrderAddressAdapterRespDTO {
    
    private String addressId;
    
    private Integer isDefault;
    
    private String streetName;
    
    private String tel;
    
    private String userId;
    
    private String userName;
}
