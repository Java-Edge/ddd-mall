

package org.opengoofy.congomall.springboot.starter.convention.exception;

import org.opengoofy.congomall.springboot.starter.convention.errorcode.BaseErrorCode;
import org.opengoofy.congomall.springboot.starter.convention.errorcode.IErrorCode;

/**
 * 客户端异常
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class ClientException extends AbstractException {
    
    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }
    
    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }
    
    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }
    
    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }
    
    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
