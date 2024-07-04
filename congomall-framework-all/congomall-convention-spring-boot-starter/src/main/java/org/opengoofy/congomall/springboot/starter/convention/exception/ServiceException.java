package org.opengoofy.congomall.springboot.starter.convention.exception;

import org.opengoofy.congomall.springboot.starter.convention.errorcode.BaseErrorCode;
import org.opengoofy.congomall.springboot.starter.convention.errorcode.IErrorCode;

/**
 * 服务端异常
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class ServiceException extends AbstractException {
    
    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }
    
    public ServiceException(IErrorCode errorCode) {
        this(null, errorCode);
    }
    
    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }
    
    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }
    
    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}