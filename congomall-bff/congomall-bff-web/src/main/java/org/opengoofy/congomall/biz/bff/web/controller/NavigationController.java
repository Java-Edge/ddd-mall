

package org.opengoofy.congomall.biz.bff.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.common.ResultT;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.NavigationAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.service.NavigationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 导航栏控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "商城导航栏")
public class NavigationController {
    
    private final NavigationService navigationService;
    
    @GetMapping("/goods/navList")
    @ApiOperation(value = "获取导航栏数据", notes = "获取所有导航栏数据")
    public ResultT<List<NavigationAdapterRespDTO>> listAllNavigation() {
        return ResultT.success(navigationService.listAllNavigation());
    }
}
