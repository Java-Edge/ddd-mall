

package org.opengoofy.congomall.springboot.starter.convention.errorcode;

/**
 * 平台错误码
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface IErrorCode {
    
    /**
     * 错误码
     */
    String code();
    
    /**
     * 错误信息
     */
    String message();
}
