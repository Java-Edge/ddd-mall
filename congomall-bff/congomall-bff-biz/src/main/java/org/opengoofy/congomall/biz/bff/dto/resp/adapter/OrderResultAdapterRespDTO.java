

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 订单返回包装适配返回
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResultAdapterRespDTO {
    
    private Integer total;
    
    private List<OrderAdapterRespDTO> data;
}
