

package org.opengoofy.congomall.biz.customer.user.domain.aggregate;

import cn.hutool.core.util.StrUtil;
import lombok.*;
import org.opengoofy.congomall.biz.customer.user.domain.dp.*;
import org.opengoofy.congomall.biz.customer.user.domain.event.OperationLogEvent;
import org.opengoofy.congomall.biz.customer.user.domain.mode.ReceiveAddress;
import org.opengoofy.congomall.biz.customer.user.domain.toolkit.JWTUtil;
import org.opengoofy.congomall.springboot.starter.common.toolkit.EnvironmentUtil;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;

import java.util.List;

/**
 * C 端用户实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class CustomerUser {
    
    private Long customerUserId;
    
    private CustomerUserName username;
    
    private CustomerUserPhone phone;
    
    private CustomerUserMail mail;
    
    private transient CustomerUserPassword password;
    
    private CustomerUserAccountNumber accountNumber;
    
    private String receiver;
    
    private String verifyCode;
    
    private OperationLogEvent operationLogEvent;
    
    private List<ReceiveAddress> receiveAddresses;
    
    public void checkoutValidCode(String verifyCode) {
        if (EnvironmentUtil.isProdEnvironment()) {
            if (StrUtil.isBlank(verifyCode)) {
                throw new ClientException("验证码已失效");
            }
            verifyCode = StrUtil.trim(verifyCode);
            this.verifyCode = StrUtil.trim(this.verifyCode);
            if (!StrUtil.equals(verifyCode, this.verifyCode)) {
                throw new ClientException("验证码错误");
            }
        }
    }
    
    public String generateAccessToken() {
        return JWTUtil.generateAccessToken(this);
    }
    
    public String getUsername() {
        return this.username.getUsername();
    }
    
    public String getAccountNumber() {
        return this.accountNumber.getAccountNumber();
    }
    
    public String getMail() {
        return this.mail.getMail();
    }
    
    public String getPhone() {
        return this.phone.getPhone();
    }
}
