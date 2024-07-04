

package org.opengoofy.congomall.biz.cart.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.math.BigDecimal;

/**
 * 商品购物车
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("cart_item")
public class CartItemDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品 spu id
     */
    private Long productId;
    
    /**
     * 商品 sku id
     */
    private Long productSkuId;
    
    /**
     * c 端用户 id
     */
    private Long customerUserId;
    
    /**
     * 商品图
     */
    private String productPic;
    
    /**
     * 商品名称
     */
    private String productName;
    
    /**
     * 商品品牌
     */
    private String productBrand;
    
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    
    /**
     * 加购物车数量
     */
    private Integer productQuantity;
    
    /**
     * 商品规格，json 格式
     */
    private String productAttribute;
    
    /**
     * 选中标志
     */
    private Integer selectFlag;
}
