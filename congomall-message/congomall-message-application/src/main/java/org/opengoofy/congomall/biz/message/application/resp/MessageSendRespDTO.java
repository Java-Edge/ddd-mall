

package org.opengoofy.congomall.biz.message.application.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 消息发送返回实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@AllArgsConstructor
public class MessageSendRespDTO {
    
    /**
     * 消息发送ID
     */
    private String messageSendId;
}
