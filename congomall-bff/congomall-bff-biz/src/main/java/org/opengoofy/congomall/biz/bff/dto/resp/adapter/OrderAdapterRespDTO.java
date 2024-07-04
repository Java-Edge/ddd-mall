

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 订单适配返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class OrderAdapterRespDTO {
    
    private String orderId;
    
    private String orderStatus;
    
    private Integer orderTotal;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date payDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date closeDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date finishDate;
    
    private List<OrderGoodsAdapterRespDTO> goodsList;
    
    private OrderAddressAdapterRespDTO addressInfo;
}
