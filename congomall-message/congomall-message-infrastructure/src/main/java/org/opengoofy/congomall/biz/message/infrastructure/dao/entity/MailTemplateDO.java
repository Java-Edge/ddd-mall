

package org.opengoofy.congomall.biz.message.infrastructure.dao.entity;

import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 邮件模板
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("mail_template")
public class MailTemplateDO extends BaseDO {
    
    /**
     * ID
     */
    private Long id;
    
    /**
     * 模板名称
     */
    private String templateName;
    
    /**
     * 模板id
     */
    private String templateId;
    
    /**
     * 模板参数
     */
    private String templateParam;
}
