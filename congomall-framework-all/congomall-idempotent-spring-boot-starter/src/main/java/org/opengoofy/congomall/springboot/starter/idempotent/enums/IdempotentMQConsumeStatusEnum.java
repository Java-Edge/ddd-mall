

package org.opengoofy.congomall.springboot.starter.idempotent.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * 幂等 MQ 消费状态枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RequiredArgsConstructor
public enum IdempotentMQConsumeStatusEnum {
    
    /**
     * 消费中
     */
    CONSUMING("0"),
    
    /**
     * 已消费
     */
    CONSUMED("1");
    
    @Getter
    private final String code;
    
    /**
     * 如果消费状态等于消费中，返回失败
     *
     * @param consumeStatus 消费状态
     * @return 是否消费失败
     */
    public static boolean isError(String consumeStatus) {
        return Objects.equals(CONSUMING.code, consumeStatus);
    }
}
