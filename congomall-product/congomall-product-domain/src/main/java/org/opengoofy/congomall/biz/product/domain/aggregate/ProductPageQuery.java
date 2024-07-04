

package org.opengoofy.congomall.biz.product.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.ddd.framework.core.domain.ValueObject;

/**
 * 商品分页查询
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageQuery implements ValueObject {
    
    private Integer sort;
    
    private Integer priceGt;
    
    private Integer priceLte;
    
    private Long current;
    
    private Long size;
}
