

package org.opengoofy.congomall.biz.message.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

/**
 * 消息发送扩展记录 DO
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("send_record_extend")
public class SendRecordExtendDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 消息发送id
     */
    private String msgId;
    
    /**
     * 发送参数
     */
    private String msgParam;
    
    /**
     * 消息文本
     */
    private String msgContent;
}
