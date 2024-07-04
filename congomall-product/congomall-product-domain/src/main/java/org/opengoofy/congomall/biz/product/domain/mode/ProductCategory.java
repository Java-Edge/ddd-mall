

package org.opengoofy.congomall.biz.product.domain.mode;

import org.opengoofy.congomall.biz.product.domain.dto.ProductCategoryDTO;
import lombok.*;

import java.util.List;

/**
 * 商品分类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class ProductCategory {
    
    /**
     * 商品分类信息
     */
    private List<ProductCategoryDTO> productCategoryList;
}
