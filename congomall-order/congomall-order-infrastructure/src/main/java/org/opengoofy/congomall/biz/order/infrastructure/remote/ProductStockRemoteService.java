

package org.opengoofy.congomall.biz.order.infrastructure.remote;

import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.ProductLockStockReqDTO;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.ProductUnlockStockReqDTO;
import org.opengoofy.congomall.biz.order.infrastructure.remote.dto.ProductVerifyStockReqDTO;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 商品库存服务远程调用
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient(value = "product-service", url = "${congomall.aggregation.remote-url:}")
public interface ProductStockRemoteService {
    
    /**
     * 验证商品库存
     */
    @PostMapping("/api/product/stock/verify")
    Result<Boolean> verifyProductStock(@RequestBody List<ProductVerifyStockReqDTO> requestParams);
    
    /**
     * 锁定商品库存
     */
    @PutMapping("/api/product/stock/lock")
    Result<Boolean> lockProductStock(@RequestBody ProductLockStockReqDTO requestParam);
    
    /**
     * 解锁商品库存
     */
    @PutMapping("/api/product/stock/unlock")
    Result<Boolean> unlockProductStock(@RequestBody ProductUnlockStockReqDTO requestParam);
}
