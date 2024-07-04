

package org.opengoofy.congomall.biz.bff.remote.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品详情出参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductRespDTO {
    
    @ApiModelProperty(value = "商品品牌")
    private ProductBrandRespDTO productBrand;
    
    @ApiModelProperty(value = "商品 SPU")
    private ProductSpuRespDTO productSpu;
    
    @ApiModelProperty(value = "商品 SKU")
    private List<ProductSkuRespDTO> productSkus;
}
