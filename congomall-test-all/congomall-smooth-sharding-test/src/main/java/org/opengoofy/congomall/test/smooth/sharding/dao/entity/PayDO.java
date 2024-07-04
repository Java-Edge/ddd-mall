

package org.opengoofy.congomall.test.smooth.sharding.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.util.Date;

/**
 * 支付 DO
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("pay_info")
public class PayDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 支付单号
     */
    private String payNo;
    
    /**
     * 支付时间
     */
    private Date payTime;
}
