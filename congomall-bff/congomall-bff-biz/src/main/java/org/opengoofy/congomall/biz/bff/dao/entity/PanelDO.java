

package org.opengoofy.congomall.biz.bff.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

/**
 * 板块实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("panel")
public class PanelDO extends BaseDO {
    
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 位置
     */
    private Integer position;
    
    /**
     * 限制数量
     */
    private Integer limitNum;
    
    /**
     * 排序
     */
    private Integer sortOrder;
    
    /**
     * 状态
     */
    private Integer status;
    
    /**
     * 类型
     */
    private Integer type;
    
    /**
     * 备注
     */
    private String remark;
}
