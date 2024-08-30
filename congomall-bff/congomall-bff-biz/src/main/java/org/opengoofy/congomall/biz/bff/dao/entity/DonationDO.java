package org.opengoofy.congomall.biz.bff.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.util.Date;

/**
 * 捐赠实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("donation")
public class DonationDO extends BaseDO {
    
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 支付方式 0：支付宝
     */
    private Integer payType;
    
    /**
     * 捐赠金额
     */
    private Integer money;
    
    /**
     * 留言
     */
    private String info;
    
    /**
     * 捐赠时间
     */
    private Date time;
}
