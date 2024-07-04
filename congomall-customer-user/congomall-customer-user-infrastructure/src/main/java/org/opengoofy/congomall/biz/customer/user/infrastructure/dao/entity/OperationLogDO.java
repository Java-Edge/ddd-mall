

package org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity;

import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * C 端用户操作日志
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@TableName("operation_log")
public class OperationLogDO extends BaseDO {
    
    /**
     * id
     */
    @TableId(type = AUTO)
    private Long id;
    
    /**
     * C端用户ID
     */
    private Long customerUserId;
    
    /**
     * 修改前
     */
    private String beforeContent;
    
    /**
     * 修改后
     */
    private String afterContent;
    
    /**
     * 修改内容
     */
    private String operationContent;
    
    public OperationLogDO(String afterContent) {
        this.afterContent = afterContent;
    }
    
    public OperationLogDO(String beforeContent, String afterContent, String operationContent) {
        this.beforeContent = beforeContent;
        this.afterContent = afterContent;
        this.operationContent = operationContent;
    }
}
