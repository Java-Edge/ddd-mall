

package org.opengoofy.congomall.biz.order.application.req;

import lombok.Data;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;

/**
 * 订单分页查询
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class OrderPageQuery extends PageRequest {
    
    /**
     * 用户 ID
     */
    private String userId;
}
