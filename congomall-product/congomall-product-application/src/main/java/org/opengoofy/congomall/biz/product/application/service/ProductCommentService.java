

package org.opengoofy.congomall.biz.product.application.service;

import org.opengoofy.congomall.biz.product.application.req.ProductCommentAppendCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentRemoveCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentSaveCommand;

/**
 * 商品评论
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductCommentService {
    
    /**
     * 新增商品评论
     *
     * @param requestParam 新增商品评论入参
     */
    void saveProductComment(ProductCommentSaveCommand requestParam);
    
    /**
     * 删除商品评论
     *
     * @param requestParam 删除商品评论入参
     */
    void removeProductComment(ProductCommentRemoveCommand requestParam);
    
    /**
     * 追加商品评论
     *
     * @param requestParam 追加商品评论入参
     */
    void appendProductComment(ProductCommentAppendCommand requestParam);
}
