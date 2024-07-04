

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.Data;

import java.util.List;

/**
 * 购物车适配返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class HomeProductDetailAdapterRespDTO {
    
    private String detail;
    
    private Integer limitNum;
    
    private String productId;
    
    private String productImageBig;
    
    private List<String> productImageSmall;
    
    private String productName;
    
    private Integer salePrice;
    
    private String subTitle;
}
