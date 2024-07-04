

package org.opengoofy.congomall.biz.customer.user.domain.event;

import org.opengoofy.congomall.biz.customer.user.domain.dto.CustomerUserDTO;
import org.opengoofy.congomall.ddd.framework.core.domain.DomainEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * C 端用户操作日志事件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
public class OperationLogEvent implements DomainEvent {
    
    /**
     * 之前的
     */
    private CustomerUserDTO beforeCustomerUser;
    
    /**
     * 操作后
     */
    private CustomerUserDTO afterCustomerUser;
    
    public OperationLogEvent(CustomerUserDTO afterCustomerUser) {
        this.afterCustomerUser = afterCustomerUser;
    }
    
    public OperationLogEvent(CustomerUserDTO beforeCustomerUser, CustomerUserDTO afterCustomerUser) {
        this.beforeCustomerUser = beforeCustomerUser;
        this.afterCustomerUser = afterCustomerUser;
    }
}
