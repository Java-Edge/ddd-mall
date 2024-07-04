package org.opengoofy.congomall.springboot.starter.common.enums;

/**
 * 标识枚举，非 {@link Boolean#TRUE} 即 {@link Boolean#FALSE}
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public enum FlagEnum {
    
    /**
     * 正常状态
     */
    FALSE(0),
    
    /**
     * 删除状态
     */
    TRUE(1);
    
    private final Integer flag;
    
    FlagEnum(Integer flag) {
        this.flag = flag;
    }
    
    public Integer code() {
        return this.flag;
    }
    
    public String strCode() {
        return String.valueOf(this.flag);
    }
    
    @Override
    public String toString() {
        return strCode();
    }
}
