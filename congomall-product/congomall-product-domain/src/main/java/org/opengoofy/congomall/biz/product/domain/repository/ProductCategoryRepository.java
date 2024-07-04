

package org.opengoofy.congomall.biz.product.domain.repository;

import org.opengoofy.congomall.biz.product.domain.mode.ProductCategory;

/**
 * 商品分类仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductCategoryRepository {
    
    /**
     * 查询所有商品分类信息
     *
     * @return
     */
    ProductCategory listAllProductCategory();
}
