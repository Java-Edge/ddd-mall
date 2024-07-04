

package org.opengoofy.congomall.biz.product.domain.repository;

import org.opengoofy.congomall.biz.product.domain.aggregate.Product;
import org.opengoofy.congomall.biz.product.domain.aggregate.ProductStock;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;

/**
 * 商品仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductRepository {
    
    /**
     * 根据 spuId 查询商品信息
     *
     * @param spuId
     * @return
     */
    Product getProductBySpuId(Long spuId);
    
    /**
     * 验证商品库存
     *
     * @param productStock 商品库存聚合根
     * @return 商品库存是否充足，全部商品库存验证无问题返回 {@link Boolean#TRUE}，反之返回 {@link Boolean#FALSE}
     */
    Boolean verifyProductStock(ProductStock productStock);
    
    /**
     * 锁定商品库存
     *
     * @param productStock 商品库存聚合根
     * @return 是否锁定相关商品库存返回结果，锁定成功返回 {@link Boolean#TRUE}，反之返回 {@link Boolean#FALSE}
     */
    Boolean lockProductStock(ProductStock productStock);
    
    /**
     * 解锁商品库存
     *
     * @param productStock 商品库存聚合根
     * @return 是否解锁相关商品库存返回结果，解锁成功返回 {@link Boolean#TRUE}，反之返回 {@link Boolean#FALSE}
     */
    Boolean unlockProductStock(ProductStock productStock);
    
    /**
     * 分页查询商品集合
     *
     * @param product 商品聚合根
     * @return 分页查询商品集合返回数据
     */
    PageResponse<Product> pageQueryProduct(Product product);
}
