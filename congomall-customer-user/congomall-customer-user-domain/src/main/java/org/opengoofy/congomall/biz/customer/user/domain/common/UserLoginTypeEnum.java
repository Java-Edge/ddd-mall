

package org.opengoofy.congomall.biz.customer.user.domain.common;

/**
 * 用户登录类型枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public enum UserLoginTypeEnum {
    
    /**
     * 邮箱验证码登录
     */
    USER_LOGIN_MAIL,
    
    /**
     * 账号密码登录
     */
    USER_LOGIN_ACCOUNT;
    
    @Override
    public String toString() {
        return this.name();
    }
}
