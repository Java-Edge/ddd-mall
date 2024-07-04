

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.dto.resp.adapter.GoodsResultAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomePanelAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomeProductDetailAdapterRespDTO;

import java.util.List;

/**
 * 商品接口层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface GoodsService {
    
    /**
     * 查询商城首页板块数据
     *
     * @return 商城首页板块返回数据
     */
    List<HomePanelAdapterRespDTO> listHomePanel();
    
    /**
     * 根据商品 ID 查询商品详情
     *
     * @param productId 商品 ID
     * @return 商品详情返回数据
     */
    HomeProductDetailAdapterRespDTO goodsDetail(String productId);
    
    /**
     * 为您推荐板块
     *
     * @return 为您推荐板块返回数据
     */
    HomePanelAdapterRespDTO recommend();
    
    /**
     * 全部商品集合
     *
     * @param page     当前页
     * @param size     每页多少条
     * @param sort     排序方式
     * @param priceGt  价格区间开始
     * @param priceLte 价格区间结束
     * @return 全部商品返回数据
     */
    GoodsResultAdapterRespDTO allGoods(Integer page, Integer size, Integer sort, Integer priceGt, Integer priceLte);
}
