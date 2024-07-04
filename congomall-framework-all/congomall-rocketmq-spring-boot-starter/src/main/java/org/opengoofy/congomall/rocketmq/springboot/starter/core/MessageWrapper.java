package org.opengoofy.congomall.rocketmq.springboot.starter.core;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * 消息体包装器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public final class MessageWrapper<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 消息发送Keys
     */
    @NonNull
    private String keys;
    
    /**
     * 消息体
     */
    @NonNull
    private T message;
    
    /**
     * 唯一标识，用于客户端幂等验证
     */
    private String uuid = UUID.randomUUID().toString();
    
    /**
     * 消息发送时间
     */
    private Long timestamp = System.currentTimeMillis();
}
