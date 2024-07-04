

package org.opengoofy.congomall.biz.message.application.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * 邮件发送
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@ApiModel("邮箱发送")
public class MailSendCommand {
    
    @ApiModelProperty(value = "标题", example = "刚果商城邮箱验证码提醒")
    @NotBlank(message = "邮箱标题不能为空")
    private String title;
    
    @Email
    @ApiModelProperty(value = "发送者", example = "congomall@163.com")
    @NotBlank(message = "邮箱发送者不能为空")
    private String sender;
    
    @Email
    @ApiModelProperty(value = "接收者", example = "m7798432@163.com", notes = "实际发送时更改为自己邮箱")
    @NotBlank(message = "邮箱接收者不能为空")
    private String receiver;
    
    @Email
    @ApiModelProperty("抄送者")
    private String cc;
    
    @ApiModelProperty(value = "消息参数")
    private List<String> paramList;
    
    @ApiModelProperty(value = "模板ID", example = "userRegisterVerification")
    @NotBlank(message = "邮箱模板ID不能为空")
    private String templateId;
}
