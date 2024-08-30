

package org.opengoofy.congomall.biz.bff.dto.req.adapter;

import lombok.Data;

/**
 * 商品购物车添加适配请求对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductCartAddAdapterReqDTO {
    
    private String productId;
    
    private Integer productNum;
    
    private String userId;
}