

package org.opengoofy.congomall.biz.product.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentAppendCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentRemoveCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentSaveCommand;
import org.opengoofy.congomall.biz.product.application.service.ProductCommentService;
import org.opengoofy.congomall.biz.product.domain.aggregate.ProductComment;
import org.opengoofy.congomall.biz.product.domain.repository.ProductCommentRepository;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Service;

/**
 * 商品评论
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@RequiredArgsConstructor
public class ProductCommentServiceImpl implements ProductCommentService {
    
    private final ProductCommentRepository productCommentRepository;
    
    @Override
    public void saveProductComment(ProductCommentSaveCommand requestParam) {
        ProductComment productComment = BeanUtil.convert(requestParam, ProductComment.class);
        productCommentRepository.saveProductComment(productComment);
    }
    
    @Override
    public void removeProductComment(ProductCommentRemoveCommand requestParam) {
        ProductComment productComment = BeanUtil.convert(requestParam, ProductComment.class);
        productCommentRepository.removeProductComment(productComment);
    }
    
    @Override
    public void appendProductComment(ProductCommentAppendCommand requestParam) {
        ProductComment productComment = BeanUtil.convert(requestParam, ProductComment.class);
        productCommentRepository.appendProductComment(productComment);
    }
}
