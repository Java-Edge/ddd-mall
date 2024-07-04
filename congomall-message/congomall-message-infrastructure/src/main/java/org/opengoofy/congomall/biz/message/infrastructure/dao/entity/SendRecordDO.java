

package org.opengoofy.congomall.biz.message.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 消息发送记录 DO
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("send_record")
public class SendRecordDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 消息发送id
     */
    @TableField("msg_id")
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
     * 状态 0：失败 1：成功
     */
    private Integer status;
    
    /**
     * 发送时间
     */
    private Date sendTime;
}
