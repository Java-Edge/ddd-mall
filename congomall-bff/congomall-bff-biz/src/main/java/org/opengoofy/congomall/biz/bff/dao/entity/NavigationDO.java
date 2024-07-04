package org.opengoofy.congomall.biz.bff.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

/**
 * 导航栏实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("navigation")
public class NavigationDO extends BaseDO {
    
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
     * 跳转地址
     */
    private String url;
    
    /**
     * 排序
     */
    private Integer sort;
}