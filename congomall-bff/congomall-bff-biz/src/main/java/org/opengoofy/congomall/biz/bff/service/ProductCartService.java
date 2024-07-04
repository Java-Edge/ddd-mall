

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.dto.req.adapter.ProductCartAddAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ProductCartChecksAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ProductCartDeleteAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ProductCartDeleteChecksAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ProductCartUpdateAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.ProductCartAdapterRespDTO;

import java.util.List;

/**
 * 购物车接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ProductCartService {
    
    /**
     * 根据用户查询所有购物车选中商品
     *
     * @param userId 用户 ID
     * @return 用户购物车返回数据
     */
    List<ProductCartAdapterRespDTO> listAllProductCart(String userId);
    
    /**
     * 添加商品到购物车
     *
     * @param requestParam 商品添加购物车请求数据
     * @return 添加购物车数量
     */
    Integer addProductCard(ProductCartAddAdapterReqDTO requestParam);
    
    /**
     * 修改商品购物车数据
     *
     * @param requestParam 修改商品购物车请求数据
     * @return 修改购物车是否成功
     */
    Integer updateProductCard(ProductCartUpdateAdapterReqDTO requestParam);
    
    /**
     * 删除商品购物车数据
     *
     * @param requestParam 删除商品购物车请求数据
     * @return 删除购物车是否成功
     */
    Integer deleteProductCard(ProductCartDeleteAdapterReqDTO requestParam);
    
    /**
     * 编辑全选商品购物车
     *
     * @param requestParam 编辑全选商品购物车请求数据
     * @return 编辑全选商品购物车是否成功
     */
    Integer updateChecksProductCard(ProductCartChecksAdapterReqDTO requestParam);
    
    /**
     * 删除选中商品购物车
     *
     * @param requestParam 删除选中商品购物车请求数据
     */
    void deleteChecksProductCard(ProductCartDeleteChecksAdapterReqDTO requestParam);
}
