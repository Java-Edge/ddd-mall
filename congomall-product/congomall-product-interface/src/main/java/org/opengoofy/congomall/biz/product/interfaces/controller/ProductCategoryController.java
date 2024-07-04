

package org.opengoofy.congomall.biz.product.interfaces.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.product.application.resp.ProductCategoryRespDTO;
import org.opengoofy.congomall.biz.product.application.service.ProductCategoryService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@MLog
@RestController
@AllArgsConstructor
@Api(tags = "商品分类")
public class ProductCategoryController {
    
    private final ProductCategoryService productCategoryService;
    
    @GetMapping("/api/product/categories")
    @ApiOperation(value = "查询商品分类集合", notes = "返回全部分类")
    public Result<List<ProductCategoryRespDTO>> listAllProductCategory() {
        return Results.success(productCategoryService.listAllProductCategory());
    }
}
