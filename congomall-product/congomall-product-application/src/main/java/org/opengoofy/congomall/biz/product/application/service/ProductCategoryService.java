

package org.opengoofy.congomall.biz.product.application.service;

import org.opengoofy.congomall.biz.product.application.resp.ProductCategoryRespDTO;

import java.util.List;

/**
 * 商品分类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductCategoryService {
    
    /**
     * 查询全部商品分类集合
     *
     * @return
     */
    List<ProductCategoryRespDTO> listAllProductCategory();
}
