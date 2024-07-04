

package org.opengoofy.congomall.biz.customer.user.application.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户验证码
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ApiModel("用户验证码")
public class UserVerifyCodeCommand {
    
    @ApiModelProperty(value = "验证类型", notes = "登录验证码，注册认证验证码等", example = "customer_user_login_verify")
    private String type;
    
    @ApiModelProperty(value = "验证平台", notes = "手机短信，邮箱，电话等", example = "mail")
    private String platform;
    
    @NotBlank(message = "接收者不能为空")
    @ApiModelProperty(value = "接收者", example = "m7798432@163.com", notes = "实际发送时更改为自己邮箱")
    private String receiver;
}
