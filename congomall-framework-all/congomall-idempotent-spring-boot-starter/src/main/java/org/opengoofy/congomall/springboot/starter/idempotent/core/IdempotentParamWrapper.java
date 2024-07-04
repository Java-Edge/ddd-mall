

package org.opengoofy.congomall.springboot.starter.idempotent.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.aspectj.lang.ProceedingJoinPoint;
import org.opengoofy.congomall.springboot.starter.idempotent.annotation.Idempotent;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentTypeEnum;

/**
 * 幂等参数包装
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public final class IdempotentParamWrapper {
    
    /**
     * 幂等注解
     */
    private Idempotent idempotent;
    
    /**
     * AOP 处理连接点
     */
    private ProceedingJoinPoint joinPoint;
    
    /**
     * 锁标识，{@link IdempotentTypeEnum#PARAM}
     */
    private String lockKey;
}
