

package org.opengoofy.congomall.biz.order.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

import java.math.BigDecimal;

/**
 * 订单商品详情
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Accessors(chain = true)
@TableName("order_item")
public class OrderItemDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 用户id
     */
    private Long customerUserId;
    
    /**
     * 订单id
     */
    private Long orderId;
    
    /**
     * 订单编号
     */
    private String orderSn;
    
    /**
     * 商品spu id
     */
    private Long productId;
    
    /**
     * 商品sku id
     */
    private Long productSkuId;
    
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
     * 商品购买数量
     */
    private Integer productQuantity;
    
    /**
     * 规格，json 格式
     */
    private String productAttribute;
}
