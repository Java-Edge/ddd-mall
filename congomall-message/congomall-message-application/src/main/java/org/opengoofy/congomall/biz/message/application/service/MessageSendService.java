

package org.opengoofy.congomall.biz.message.application.service;

import org.opengoofy.congomall.biz.message.application.req.MailSendCommand;
import org.opengoofy.congomall.biz.message.application.resp.MessageSendRespDTO;

/**
 * 消息发送
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MessageSendService {
    
    /**
     * 邮箱消息发送
     *
     * @param mailSendCommand 邮箱消息发送命令
     * @return 邮箱消息发送返回结果
     */
    MessageSendRespDTO mailMessageSend(MailSendCommand mailSendCommand);
}
