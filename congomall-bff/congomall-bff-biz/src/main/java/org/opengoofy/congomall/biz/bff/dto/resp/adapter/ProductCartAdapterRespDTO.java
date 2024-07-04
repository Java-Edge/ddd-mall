

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.Data;

/**
 * 购物车适配返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductCartAdapterRespDTO {
    
    private String checked;
    
    private Integer limitNum;
    
    private String productId;
    
    private String productImg;
    
    private String productName;
    
    private Integer productNum;
    
    private Integer salePrice;
}
