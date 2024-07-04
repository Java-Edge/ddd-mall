

package org.opengoofy.congomall.biz.customer.user.application.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

/**
 * 用户登录
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ApiModel("用户登录")
public class UserLoginCommand {
    
    @ApiModelProperty(value = "登录方式", notes = "邮箱验证码、账号密码、手机号验证码、微信二维码等", example = "UserLoginTypeEnum.USER_LOGIN_MAIL")
    private String loginType;
    
    @ApiModelProperty(value = "账号", example = "15601166692")
    private String accountNumber;
    
    @ApiModelProperty(value = "密码", example = "xiao-ma-ge")
    private String password;
    
    @ApiModelProperty(value = "手机号", example = "15601166692")
    private String phone;
    
    @ApiModelProperty(value = "邮箱", example = "m7798432@163.com", notes = "实际发送时更改为自己邮箱")
    @Email
    private String mail;
    
    @ApiModelProperty(value = "邮箱验证码", example = "123456")
    private String mailValidCode;
}
