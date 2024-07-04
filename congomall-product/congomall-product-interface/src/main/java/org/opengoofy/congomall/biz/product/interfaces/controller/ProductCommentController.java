

package org.opengoofy.congomall.biz.product.interfaces.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentAppendCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentRemoveCommand;
import org.opengoofy.congomall.biz.product.application.req.ProductCommentSaveCommand;
import org.opengoofy.congomall.biz.product.application.service.ProductCommentService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品评论控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@MLog
@RestController
@RequiredArgsConstructor
@Api(tags = "商品评论")
public class ProductCommentController {
    
    private final ProductCommentService productCommentService;
    
    @PostMapping("/api/product/comment")
    @ApiOperation(value = "新增商品评论", notes = "新增商品评论")
    public Result<Void> saveProductComment(@RequestBody ProductCommentSaveCommand requestParam) {
        productCommentService.saveProductComment(requestParam);
        return Results.success();
    }
    
    @DeleteMapping("/api/product/comment")
    @ApiOperation(value = "删除商品评论", notes = "删除商品评论")
    public Result<Void> removeProductComment(@RequestBody ProductCommentRemoveCommand requestParam) {
        productCommentService.removeProductComment(requestParam);
        return Results.success();
    }
    
    @PostMapping("/api/product/comment/append")
    @ApiOperation(value = "追加商品评论", notes = "买家追加商品评论")
    public Result<Void> appendProductComment(@RequestBody ProductCommentAppendCommand requestParam) {
        productCommentService.appendProductComment(requestParam);
        return Results.success();
    }
}
