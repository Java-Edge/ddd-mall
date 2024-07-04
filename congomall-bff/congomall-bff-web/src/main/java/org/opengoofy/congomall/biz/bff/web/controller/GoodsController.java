

package org.opengoofy.congomall.biz.bff.web.controller;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.common.ResultT;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.GoodsResultAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomePanelAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomeProductDetailAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商城首页控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "商城首页")
public class GoodsController {
    
    private final GoodsService goodsService;
    
    @GetMapping("/goods/home")
    @ApiOperation(value = "商城首页板块商品数据", notes = "商城首页板块商品数据")
    public ResultT<List<HomePanelAdapterRespDTO>> goodsHome() {
        return ResultT.success(goodsService.listHomePanel());
    }
    
    @GetMapping("/goods/productDet")
    @ApiOperation(value = "商品详情", notes = "根据商品ID查询商品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品ID", required = true, example = "1647801029158240256")
    })
    public ResultT<HomeProductDetailAdapterRespDTO> goodsDetail(@RequestParam("productId") String productId) {
        return ResultT.success(goodsService.goodsDetail(productId));
    }
    
    @GetMapping("/goods/recommend")
    @ApiOperation(value = "为您推荐", notes = "为您推荐")
    public ResultT<List<HomePanelAdapterRespDTO>> recommend() {
        return ResultT.success(Lists.newArrayList(goodsService.recommend()));
    }
    
    @GetMapping("/goods/allGoods")
    @ApiOperation(value = "全部商品", notes = "全部商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "全部商品列表第几页", required = true, example = "1"),
            @ApiImplicitParam(name = "size", value = "全部商品列表每页多少条数据", required = true, example = "10"),
            @ApiImplicitParam(name = "sort", value = "排序方式", example = "1"),
            @ApiImplicitParam(name = "priceGt", value = "价格区间开始", example = "1"),
            @ApiImplicitParam(name = "priceLte", value = "价格区间结束", example = "1")
    })
    public ResultT<GoodsResultAdapterRespDTO> allGoods(@RequestParam("page") Integer page,
                                                       @RequestParam("size") Integer size,
                                                       @RequestParam(value = "sort", required = false) Integer sort,
                                                       @RequestParam(value = "priceGt", required = false) Integer priceGt,
                                                       @RequestParam(value = "priceLte", required = false) Integer priceLte) {
        return ResultT.success(goodsService.allGoods(page, size, sort, priceGt, priceLte));
    }
}
