

package org.opengoofy.congomall.springboot.starter.idempotent.core.token;

import org.opengoofy.congomall.springboot.starter.idempotent.core.IdempotentExecuteHandler;

/**
 * Token 实现幂等接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface IdempotentTokenService extends IdempotentExecuteHandler {
    
    /**
     * 创建幂等验证Token
     */
    String createToken();
}
