

package org.opengoofy.congomall.biz.message.domain.event;

import org.opengoofy.congomall.ddd.framework.core.domain.DomainEvent;
import lombok.Data;

import java.util.Date;

/**
 * 邮箱消息发送事件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class MailMessageSendEvent implements DomainEvent {
    
    /**
     * 消息发送id
     */
    private String messageSendId;
    
    /**
     * 模板id
     */
    private String templateId;
    
    /**
     * 模板类型 0：短信-验证码 1：短信-通知 2：短信-营销 3：微信模板消息 4：邮箱 5...
     */
    private Integer msgType;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 发送者
     */
    private String sender;
    
    /**
     * 接收者
     */
    private String receiver;
    
    /**
     * 抄送者
     */
    private String cc;
    
    /**
     * 文本参数
     */
    private String paramList;
    
    /**
     * 状态 0：成功 1：失败
     */
    private Integer status;
    
    /**
     * 发送时间
     */
    private Date sendTime;
}
