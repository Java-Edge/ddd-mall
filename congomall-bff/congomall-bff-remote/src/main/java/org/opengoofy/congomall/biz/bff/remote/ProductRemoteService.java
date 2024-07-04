

package org.opengoofy.congomall.biz.bff.remote;

import org.opengoofy.congomall.biz.bff.remote.resp.ProductRespDTO;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品服务远程调用
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient(value = "product-service", url = "${congomall.aggregation.remote-url:}")
public interface ProductRemoteService {
    
    /**
     * 根据 SpuID 查询商品详情
     */
    @GetMapping("/api/product/spu/{spuId}")
    Result<ProductRespDTO> getProductBySpuId(@PathVariable("spuId") String spuId);
    
    /**
     * 商品分页查询返回 SPU 信息
     */
    @GetMapping("/api/product/page")
    Result<PageResponse<ProductRespDTO>> pageQueryProduct(@RequestParam("current") Integer page,
                                                          @RequestParam("size") Integer size,
                                                          @RequestParam(value = "sort", required = false) Integer sort,
                                                          @RequestParam(value = "priceGt", required = false) Integer priceGt,
                                                          @RequestParam(value = "priceLte", required = false) Integer priceLte);
}
