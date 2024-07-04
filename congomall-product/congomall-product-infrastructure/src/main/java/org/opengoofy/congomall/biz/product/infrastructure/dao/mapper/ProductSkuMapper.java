

package org.opengoofy.congomall.biz.product.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;
import org.opengoofy.congomall.biz.product.infrastructure.dao.entity.ProductSkuDO;

/**
 * 商品 SKU
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductSkuMapper extends BaseMapper<ProductSkuDO> {
    
    /**
     * 锁定商品 SKU 库存
     */
    int lockSkuStock(ProductSkuDO productSkuDO);
    
    /**
     * 解锁商品 SKU 库存
     */
    int unlockSkuStock(ProductSkuDO productSkuDO);
    
    /**
     * 通过流式查询的方式获取所有商品 SKU
     */
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = Integer.MIN_VALUE)
    @ResultType(ProductSkuDO.class)
    @Select("SELECT * FROM product_sku WHERE del_flag = '0'")
    void listAllProductSkuStreamQuery(ResultHandler<ProductSkuDO> handler);
}
