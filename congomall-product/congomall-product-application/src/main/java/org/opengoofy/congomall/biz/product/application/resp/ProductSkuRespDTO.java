

package org.opengoofy.congomall.biz.product.application.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品 SKU 出参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductSkuRespDTO {
    
    @ApiModelProperty("id")
    private Long id;
    
    @ApiModelProperty("商品 id")
    private Long productId;
    
    @ApiModelProperty("价格")
    private BigDecimal price;
    
    @ApiModelProperty("库存")
    private Integer stock;
    
    @ApiModelProperty("锁定库存")
    private Integer lockStock;
    
    @ApiModelProperty("图片")
    private String pic;
    
    @ApiModelProperty("属性，json 格式")
    private String attribute;
}
