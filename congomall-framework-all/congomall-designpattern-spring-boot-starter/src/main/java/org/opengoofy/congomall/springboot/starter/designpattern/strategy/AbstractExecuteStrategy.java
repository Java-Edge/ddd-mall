

package org.opengoofy.congomall.springboot.starter.designpattern.strategy;

/**
 * 策略执行抽象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface AbstractExecuteStrategy<REQUEST, RESPONSE> {
    
    /**
     * 执行策略标识
     */
    String mark();
    
    /**
     * 执行策略
     *
     * @param requestParam 执行策略入参
     */
    default void execute(REQUEST requestParam) {
        
    }
    
    /**
     * 执行策略，带返回值
     *
     * @param requestParam 执行策略入参
     * @return 执行策略后返回值
     */
    default RESPONSE executeResp(REQUEST requestParam) {
        return null;
    }
}
