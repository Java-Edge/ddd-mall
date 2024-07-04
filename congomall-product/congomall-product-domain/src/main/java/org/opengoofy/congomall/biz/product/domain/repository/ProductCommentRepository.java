

package org.opengoofy.congomall.biz.product.domain.repository;

import org.opengoofy.congomall.biz.product.domain.aggregate.ProductComment;

/**
 * 商品评论仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductCommentRepository {
    
    /**
     * 新增商品评论
     *
     * @param productComment 商品评论聚合根
     */
    void saveProductComment(ProductComment productComment);
    
    /**
     * 删除商品评论
     *
     * @param productComment 商品评论聚合根
     */
    void removeProductComment(ProductComment productComment);
    
    /**
     * 追加商品评论
     *
     * @param productComment 商品评论聚合根
     */
    void appendProductComment(ProductComment productComment);
}
