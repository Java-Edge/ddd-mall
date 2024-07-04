

package org.opengoofy.congomall.biz.customer.user.application.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户注册
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ApiModel("用户注册")
public class UserRegisterCommand {
    
    @ApiModelProperty(value = "用户名", example = " JavaEdge")
    @NotBlank(message = "用户名不允许为空")
    private String username;
    
    @ApiModelProperty(value = "账号", example = "15601166692")
    @NotBlank(message = "账号不允许为空")
    private String accountNumber;
    
    @ApiModelProperty(value = "密码", example = "xiao-ma-ge")
    @NotBlank(message = "密码不允许为空")
    private String password;
    
    @ApiModelProperty(value = "手机号", example = "15601166692")
    @NotBlank(message = "手机号不允许为空")
    private String phone;
    
    @Email
    @ApiModelProperty(value = "邮箱", example = "m7798432@163.com", notes = "实际发送时更改为自己邮箱")
    @NotBlank(message = "邮箱不允许为空")
    private String mail;
    
    @ApiModelProperty(value = "邮箱验证码", example = "123456")
    @NotBlank(message = "邮箱验证码不允许为空")
    private String mailValidCode;
}
