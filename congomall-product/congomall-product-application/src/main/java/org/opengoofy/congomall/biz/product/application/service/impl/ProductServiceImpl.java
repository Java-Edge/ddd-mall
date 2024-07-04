

package org.opengoofy.congomall.biz.product.application.service.impl;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.product.application.req.ProductLockStockCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductPageQuery;
import org.opengoofy.congomall.biz.product.application.req.ProductStockVerifyQuery;
import org.opengoofy.congomall.biz.product.application.req.ProductUnlockStockCommand;
import org.opengoofy.congomall.biz.product.application.resp.ProductRespDTO;
import org.opengoofy.congomall.biz.product.application.service.ProductService;
import org.opengoofy.congomall.biz.product.domain.aggregate.Product;
import org.opengoofy.congomall.biz.product.domain.aggregate.ProductStock;
import org.opengoofy.congomall.biz.product.domain.aggregate.ProductStockDetail;
import org.opengoofy.congomall.biz.product.domain.repository.ProductRepository;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Override
    public ProductRespDTO getProductBySpuId(Long spuId) {
        Product product = productRepository.getProductBySpuId(spuId);
        return BeanUtil.convert(product, ProductRespDTO.class);
    }
    
    @Override
    public Boolean verifyProductStock(List<ProductStockVerifyQuery> requestParams) {
        ProductStock productStock = ProductStock.builder().productStockDetails(BeanUtil.convert(requestParams, ProductStockDetail.class)).build();
        return productRepository.verifyProductStock(productStock);
    }
    
    @Override
    public Boolean lockProductStock(ProductLockStockCommand requestParam) {
        return productRepository.lockProductStock(BeanUtil.convert(requestParam, ProductStock.class));
    }
    
    @Override
    public Boolean unlockProductStock(ProductUnlockStockCommand requestParam) {
        return productRepository.unlockProductStock(BeanUtil.convert(requestParam, ProductStock.class));
    }
    
    @Override
    public PageResponse<ProductRespDTO> pageQueryProduct(ProductPageQuery requestParam) {
        Product product = Product.builder()
                .pageQuery(BeanUtil.convert(requestParam, org.opengoofy.congomall.biz.product.domain.aggregate.ProductPageQuery.class))
                .build();
        PageResponse<Product> productPageResponse = productRepository.pageQueryProduct(product);
        return PageResponse.<ProductRespDTO>builder()
                .current(productPageResponse.getCurrent())
                .size(productPageResponse.getSize())
                .total(productPageResponse.getTotal())
                .records(BeanUtil.convert(productPageResponse.getRecords(), ProductRespDTO.class))
                .build();
    }
}
