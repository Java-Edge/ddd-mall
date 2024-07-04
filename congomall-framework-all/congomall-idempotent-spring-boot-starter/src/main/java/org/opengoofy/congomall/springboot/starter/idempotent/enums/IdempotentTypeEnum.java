

package org.opengoofy.congomall.springboot.starter.idempotent.enums;

/**
 * 幂等验证类型枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public enum IdempotentTypeEnum {
    
    /**
     * 基于 Token 方式验证
     */
    TOKEN,
    
    /**
     * 基于方法参数方式验证
     */
    PARAM,
    
    /**
     * 基于 SpEL 表达式方式验证
     */
    SPEL
}
