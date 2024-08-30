

package org.opengoofy.congomall.biz.bff.remote.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 查询选中购物车商品出参
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CartItemQuerySelectRespDTO {
    
    @ApiModelProperty("商品 spu id")
    private String productId;
    
    @ApiModelProperty("商品 sku id")
    private String productSkuId;
    
    @ApiModelProperty("c 端用户 id")
    private String customerUserId;
    
    @ApiModelProperty("商品图")
    private String productPic;
    
    @ApiModelProperty("商品名称")
    private String productName;
    
    @ApiModelProperty("商品品牌")
    private String productBrand;
    
    @ApiModelProperty("商品价格")
    private BigDecimal productPrice;
    
    @ApiModelProperty("加购物车数量")
    private Integer productQuantity;
    
    @ApiModelProperty("限制购物车数量")
    private Integer limitNum;
    
    @ApiModelProperty("商品规格，json 格式")
    private String productAttribute;
}