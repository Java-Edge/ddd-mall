

package org.opengoofy.congomall.springboot.starter.convention.exception;

import org.opengoofy.congomall.springboot.starter.convention.errorcode.IErrorCode;

/**
 * 远程服务调用异常
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class RemoteException extends AbstractException {
    
    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }
    
    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }
    
    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
