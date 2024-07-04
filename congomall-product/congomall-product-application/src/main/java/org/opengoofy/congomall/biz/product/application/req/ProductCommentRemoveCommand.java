

package org.opengoofy.congomall.biz.product.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品评论删除
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductCommentRemoveCommand {
    
    @ApiModelProperty("id")
    private String id;
    
    @ApiModelProperty("商品id")
    private String productId;
}
