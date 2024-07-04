

package org.opengoofy.congomall.biz.product.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import org.opengoofy.congomall.biz.product.domain.dto.ProductCategoryDTO;
import org.opengoofy.congomall.biz.product.domain.mode.ProductCategory;
import org.opengoofy.congomall.biz.product.domain.repository.ProductCategoryRepository;
import org.opengoofy.congomall.biz.product.infrastructure.dao.entity.ProductCategoryDO;
import org.opengoofy.congomall.biz.product.infrastructure.dao.mapper.ProductCategoryMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品分类仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
@AllArgsConstructor
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {
    
    private final ProductCategoryMapper productCategoryMapper;
    
    @Override
    public ProductCategory listAllProductCategory() {
        LambdaQueryWrapper<ProductCategoryDO> queryWrapper = Wrappers.lambdaQuery(ProductCategoryDO.class).eq(ProductCategoryDO::getStatus, 0);
        List<ProductCategoryDO> productCategoryDOS = productCategoryMapper.selectList(queryWrapper);
        return ProductCategory.builder().productCategoryList(BeanUtil.copyToList(productCategoryDOS, ProductCategoryDTO.class)).build();
    }
}
