

package org.opengoofy.congomall.springboot.starter.common.enums;

/**
 * 状态枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public enum StatusEnum {
    
    /**
     * 成功
     */
    SUCCESS(0),
    
    /**
     * 失败
     */
    FAIL(1);
    
    private final Integer statusCode;
    
    StatusEnum(Integer statusCode) {
        this.statusCode = statusCode;
    }
    
    public Integer code() {
        return this.statusCode;
    }
    
    public String strCode() {
        return String.valueOf(this.statusCode);
    }
    
    @Override
    public String toString() {
        return strCode();
    }
}
