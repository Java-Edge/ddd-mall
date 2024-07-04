

package org.opengoofy.congomall.biz.message.application.resp;

import lombok.Data;

/**
 * 消息发送结果查询返回实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class MessageSendQueryRespDTO {
    
    /**
     * 消息发送ID
     */
    private String messageSendId;
    
    /**
     * 接收者
     */
    private String receiver;
    
    /**
     * 消息状态: 0：发送成功 1：发送失败 2：发送中 3：提交失败
     */
    private Integer status;
}
