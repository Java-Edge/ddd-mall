

package org.opengoofy.congomall.biz.message.domain.entity;

import lombok.*;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

import java.util.Date;
import java.util.List;

/**
 * 消息发送查询 Entity
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageSendQuery implements AggregateRoot {
    
    /**
     * 开始时间
     */
    private Date startTime;
    
    /**
     * 结束时间
     */
    private Date endTime;
    
    /**
     * 消息发送 ID 集合
     */
    private List<Long> messageSendIdList;
    
    /**
     * 接收者集合
     */
    private List<String> receiverList;
    
    /**
     * 消息发送 ID
     */
    private Long messageSendId;
    
    /**
     * 接收者
     */
    private String receiver;
    
    /**
     * 消息状态: 0：发送成功 1：发送失败 2：发送中 3：提交失败
     */
    private Integer status;
}
