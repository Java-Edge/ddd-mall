

package org.opengoofy.congomall.biz.customer.user.application.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 删除收货地址
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ApiModel("删除收货地址")
public class ReceiveAddressDeleteCommand {
    
    /**
     * 收货地址id
     */
    private String id;
    
    /**
     * c端用户id
     */
    private String customerUserId;
}
