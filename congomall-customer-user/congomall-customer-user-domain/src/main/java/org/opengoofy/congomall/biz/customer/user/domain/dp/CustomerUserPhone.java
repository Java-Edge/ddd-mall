

package org.opengoofy.congomall.biz.customer.user.domain.dp;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import org.opengoofy.congomall.springboot.starter.convention.errorcode.BaseErrorCode;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import lombok.Data;

/**
 * C 端用户注册手机号
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CustomerUserPhone {
    
    /**
     * 注册手机号
     */
    private final String phone;
    
    public CustomerUserPhone(String phone) {
        if (StrUtil.isBlank(phone)) {
            throw new ClientException("手机号不能为空");
        } else if (!PhoneUtil.isMobile(phone)) {
            throw new ClientException(BaseErrorCode.PHONE_VERIFY_ERROR);
        }
        this.phone = phone;
    }
}
