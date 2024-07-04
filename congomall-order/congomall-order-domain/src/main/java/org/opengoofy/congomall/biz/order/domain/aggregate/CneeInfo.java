

package org.opengoofy.congomall.biz.order.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.ddd.framework.core.domain.ValueObject;

import java.util.Date;

/**
 * 收货人信息
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CneeInfo implements ValueObject {
    
    /**
     * 收货人
     */
    private String cneeName;
    
    /**
     * 收货人电话
     */
    private String cneePhone;
    
    /**
     * 收货人邮编
     */
    private String cneePostCode;
    
    /**
     * 收货人所在省
     */
    private String cneeProvinc;
    
    /**
     * 收货人所在市
     */
    private String cneeCity;
    
    /**
     * 收货人所在区
     */
    private String cneeRegion;
    
    /**
     * 收货人详细地址
     */
    private String cneeDetailAddress;
    
    /**
     * 收货时间
     */
    private Date receiveTime;
}
