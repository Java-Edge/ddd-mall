package org.opengoofy.congomall.springboot.starter.idempotent.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.opengoofy.congomall.springboot.starter.idempotent.annotation.Idempotent;

/**
 * 幂等执行处理器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface IdempotentExecuteHandler {
    
    /**
     * 幂等处理逻辑
     *
     * @param wrapper 幂等参数包装器
     */
    void handler(IdempotentParamWrapper wrapper);
    
    /**
     * 执行幂等处理逻辑
     *
     * @param joinPoint  AOP 方法处理
     * @param idempotent 幂等注解
     */
    void execute(ProceedingJoinPoint joinPoint, Idempotent idempotent);
    
    /**
     * 异常流程处理
     */
    default void exceptionProcessing() {
        
    }
    
    /**
     * 后置处理
     */
    default void postProcessing() {
        
    }
}