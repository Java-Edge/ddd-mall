

package org.opengoofy.congomall.springboot.starter.idempotent.enums;

/**
 * 幂等验证场景枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public enum IdempotentSceneEnum {
    
    /**
     * 基于 RestAPI 场景验证
     */
    RESTAPI,
    
    /**
     * 基于 MQ 场景验证
     */
    MQ
}
