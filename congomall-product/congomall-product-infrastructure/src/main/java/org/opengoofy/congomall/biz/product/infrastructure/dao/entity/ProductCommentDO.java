

package org.opengoofy.congomall.biz.product.infrastructure.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.opengoofy.congomall.mybatisplus.springboot.starter.BaseDO;

/**
 * 商品评论实体
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@TableName("product_comment")
public class ProductCommentDO extends BaseDO {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 上级id，一级评论为0
     */
    private Long parentId;
    
    /**
     * 商品id
     */
    private Long productId;
    
    /**
     * 商品sku id
     */
    private Long productSkuId;
    
    /**
     * 用户id
     */
    private Long customerUserId;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 回复数
     */
    private Integer replyCount;
    
    /**
     * 评分
     */
    private Integer star;
    
    /**
     * 评论
     */
    private String content;
    
    /**
     * 回复标识 0：用户 1：店家
     */
    private Integer commentFlag;
    
    /**
     * 匿名标识 0：匿名 1：不匿名
     */
    private Integer hideFlag;
    
    /**
     * 追加标识 0：否 1：是
     */
    private Integer appendFlag;
    
    /**
     * 评论图片/视频，json格式
     */
    private String resource;
}
