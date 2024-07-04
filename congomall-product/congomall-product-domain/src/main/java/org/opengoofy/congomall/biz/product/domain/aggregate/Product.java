

package org.opengoofy.congomall.biz.product.domain.aggregate;

import lombok.*;
import org.opengoofy.congomall.biz.product.domain.mode.ProductBrand;
import org.opengoofy.congomall.biz.product.domain.mode.ProductSpu;
import org.opengoofy.congomall.biz.product.domain.mode.ProductSku;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

import java.util.List;

/**
 * 商品信息
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Product implements AggregateRoot {
    
    /**
     * 商品品牌
     */
    private ProductBrand productBrand;
    
    /**
     * 商品 SPU
     */
    private ProductSpu productSpu;
    
    /**
     * 商品 SKU 集合
     */
    private List<ProductSku> productSkus;
    
    /**
     * 分页查询
     */
    private ProductPageQuery pageQuery;
}
