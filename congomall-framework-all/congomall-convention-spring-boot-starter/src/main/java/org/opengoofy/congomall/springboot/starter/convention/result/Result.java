package org.opengoofy.congomall.springboot.starter.convention.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 全局返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    
    private static final long serialVersionUID = 5679018624309023727L;
    
    /**
     * 正确返回码
     */
    public static final String SUCCESS_CODE = "0";
    
    /**
     * 返回码
     */
    private String code;
    
    /**
     * 返回消息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 请求ID
     */
    private String requestId;
    
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }
}
