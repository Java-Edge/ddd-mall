

package org.opengoofy.congomall.biz.bff.dto.req.adapter;

import lombok.Data;

/**
 * 收货地址新增适配请求对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ReceiveAddressSaveAdapterReqDTO {
    
    private Boolean isDefault;
    
    private String streetName;
    
    private String tel;
    
    private String userId;
    
    private String userName;
}
