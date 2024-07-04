

package org.opengoofy.congomall.biz.bff.remote.req;

import lombok.Data;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;

/**
 * 商品分页查询
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductPageQuery extends PageRequest {
    
    private Integer sort;
    
    private Integer priceGt;
    
    private Integer priceLte;
}
