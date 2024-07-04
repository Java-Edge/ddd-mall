

package org.opengoofy.congomall.biz.customer.user.infrastructure.remote.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 邮件发送
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Accessors(chain = true)
public class MailSendRemoteCommand {
    
    /**
     * 标题
     */
    @NotBlank(message = "邮箱标题不能为空")
    private String title;
    
    /**
     * 发送者
     */
    @NotBlank(message = "邮箱发送者不能为空")
    private String sender;
    
    /**
     * 接收者
     */
    @NotBlank(message = "邮箱接收者不能为空")
    private String receiver;
    
    /**
     * 抄送
     */
    private String cc;
    
    /**
     * 消息参数
     */
    private List<String> paramList;
    
    /**
     * 模板ID
     */
    @NotBlank(message = "邮箱模板ID不能为空")
    private String templateId;
}
