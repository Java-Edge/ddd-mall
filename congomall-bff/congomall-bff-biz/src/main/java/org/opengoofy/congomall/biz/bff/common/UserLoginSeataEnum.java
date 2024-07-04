

package org.opengoofy.congomall.biz.bff.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 用户登录状态枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RequiredArgsConstructor
public enum UserLoginSeataEnum {
    
    /**
     * 成功
     */
    SUCCESS(1),
    
    /**
     * 失败
     */
    FAIL(0);
    
    @Getter
    private final int code;
}
