

package org.opengoofy.congomall.biz.customer.user.infrastructure.mq.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import org.opengoofy.congomall.biz.customer.user.domain.event.OperationLogEvent;
import org.opengoofy.congomall.biz.customer.user.domain.repository.CustomerUserRepository;
import org.opengoofy.congomall.biz.customer.user.infrastructure.mq.messaging.UserSink;
import org.opengoofy.congomall.rocketmq.springboot.starter.core.MessageWrapper;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 端用户操作日志消息消费者
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
@AllArgsConstructor
public class CustomerUserOperationLogConsume {
    
    private final CustomerUserRepository customerUserRepository;
    
    @StreamListener(UserSink.INPUT)
    public void customerUserOperationLog(@Payload MessageWrapper<OperationLogEvent> messageWrapper) {
        CustomerUser customerUser = CustomerUser.builder()
                .customerUserId(messageWrapper.getMessage().getAfterCustomerUser().getId())
                .operationLogEvent(messageWrapper.getMessage())
                .build();
        customerUserRepository.saveOperationLog(customerUser);
    }
}
