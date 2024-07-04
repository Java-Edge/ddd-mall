

package org.opengoofy.congomall.biz.bff.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

/**
 * 对接商城前端 BFF 层返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Accessors(chain = true)
public class ResultT<T> implements Serializable {
    
    private static final long serialVersionUID = 5679018624309023727L;
    
    /**
     * 正确返回码
     */
    public static final int SUCCESS_CODE = 200;
    
    /**
     * 正确返回信息
     */
    public static final String SUCCESS_MESSAGE = "success";
    
    /**
     * 返回码
     */
    private int code;
    
    /**
     * 返回消息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T result;
    
    /**
     * 当前返回时间戳
     */
    private long timestamp = System.currentTimeMillis();
    
    public boolean isSuccess() {
        return Objects.equals(SUCCESS_CODE, code);
    }
    
    public static <T> ResultT<T> success() {
        return new ResultT().setCode(SUCCESS_CODE).setMessage(SUCCESS_MESSAGE);
    }
    
    public static <T> ResultT<T> success(T data) {
        return new ResultT().setCode(SUCCESS_CODE).setMessage(SUCCESS_MESSAGE).setResult(data);
    }
}