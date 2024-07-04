

package org.opengoofy.congomall.biz.product.application.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.opengoofy.congomall.biz.product.application.resp.ProductCategoryRespDTO;
import org.opengoofy.congomall.biz.product.application.service.ProductCategoryService;
import org.opengoofy.congomall.biz.product.domain.mode.ProductCategory;
import org.opengoofy.congomall.biz.product.domain.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    
    private final ProductCategoryRepository productCategoryRepository;
    
    @Override
    public List<ProductCategoryRespDTO> listAllProductCategory() {
        ProductCategory productCategory = productCategoryRepository.listAllProductCategory();
        return BeanUtil.copyToList(productCategory.getProductCategoryList(), ProductCategoryRespDTO.class);
    }
}
