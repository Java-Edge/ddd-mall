

package org.opengoofy.congomall.biz.product.interfaces.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.product.application.req.ProductLockStockCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductStockVerifyQuery;
import org.opengoofy.congomall.biz.product.application.req.ProductUnlockStockCommand;
import org.opengoofy.congomall.biz.product.application.service.ProductService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.idempotent.annotation.Idempotent;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentSceneEnum;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentTypeEnum;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品库存控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@MLog
@RestController
@AllArgsConstructor
@Api(tags = "商品库存")
public class ProductStockController {
    
    private final ProductService productService;
    
    @PostMapping("/api/product/stock/verify")
    @ApiOperation(value = "验证商品库存", notes = "批量验证，可一次性传入多个商品信息")
    public Result<Boolean> verifyProductStock(@RequestBody List<ProductStockVerifyQuery> requestParams) {
        boolean result = productService.verifyProductStock(requestParams);
        return Results.success(result);
    }
    
    @Idempotent(
            key = "'stock_lock_'+#requestParam.orderSn+'_'+#requestParam.hashCode()",
            type = IdempotentTypeEnum.SPEL,
            scene = IdempotentSceneEnum.RESTAPI
    )
    @PutMapping("/api/product/stock/lock")
    @ApiOperation(value = "锁定商品库存")
    public Result<Boolean> lockProductStock(@RequestBody ProductLockStockCommand requestParam) {
        boolean result = productService.lockProductStock(requestParam);
        return Results.success(result);
    }
    
    @Idempotent(
            key = "'stock_unlock_'+#requestParam.orderSn+'_'+#requestParam.hashCode()",
            type = IdempotentTypeEnum.SPEL,
            scene = IdempotentSceneEnum.RESTAPI
    )
    @PutMapping("/api/product/stock/unlock")
    @ApiOperation(value = "解锁商品库存")
    public Result<Boolean> unlockProductStock(@RequestBody ProductUnlockStockCommand requestParam) {
        boolean result = productService.unlockProductStock(requestParam);
        return Results.success(result);
    }
}
