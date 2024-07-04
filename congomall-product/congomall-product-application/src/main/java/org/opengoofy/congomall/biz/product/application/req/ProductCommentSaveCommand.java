

package org.opengoofy.congomall.biz.product.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品评论新增
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductCommentSaveCommand {
    
    @ApiModelProperty("上级id，一级评论为0")
    private String parentId;
    
    @ApiModelProperty("商品id")
    private String productId;
    
    @ApiModelProperty("商品sku id")
    private String productSkuId;
    
    @ApiModelProperty("用户id")
    private String customerUserId;
    
    @ApiModelProperty("评分")
    private Integer star;
    
    @ApiModelProperty("评论")
    private String content;
    
    @ApiModelProperty("回复标识 0：用户 1：店家")
    private Integer commentFlag;
    
    @ApiModelProperty("匿名标识 0：匿名 1：不匿名")
    private Integer hideFlag;
    
    @ApiModelProperty("追加标识 0：否 1：是")
    private Integer appendFlag;
    
    @ApiModelProperty("评论图片/视频，json格式")
    private String resource;
}
