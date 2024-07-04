

package org.opengoofy.congomall.biz.basicdata.interfaces.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.basicdata.application.resp.RegionInfoRespDTO;
import org.opengoofy.congomall.biz.basicdata.application.service.RegionInfoService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 行政区划控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@Api(tags = "行政区划")
@RequiredArgsConstructor
public class RegionInfoController {
    
    private final RegionInfoService regionInfoService;
    
    @MLog(output = false)
    @GetMapping("/api/basics-data/region/all")
    @ApiOperation(value = "查询行政区划数据", notes = "查询所有行政区划数据")
    public Result<List<RegionInfoRespDTO>> listAllRegionInfo() {
        return Results.success(regionInfoService.listAllRegionInfo());
    }
    
    @MLog(output = false)
    @GetMapping("/api/basics-data/region/list/level/{level}")
    @ApiOperation(value = "查询行政区划数据", notes = "根据层级查询行政区划数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "层级", example = "1")
    })
    public Result<List<RegionInfoRespDTO>> listRegionInfoByLevel(@PathVariable("level") Integer level) {
        return Results.success(regionInfoService.listRegionInfoByLevel(level));
    }
    
    @MLog(output = false)
    @GetMapping("/api/basics-data/region/list/code/{code}")
    @ApiOperation(value = "查询行政区划数据", notes = "根据编号查询行政区划数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "行政区划编号", example = "110000")
    })
    public Result<List<RegionInfoRespDTO>> listRegionInfoByCode(@PathVariable("code") String code) {
        return Results.success(regionInfoService.listRegionInfoByCode(code));
    }
    
    @MLog(output = false)
    @GetMapping("/api/basics-data/region/list/parent/{parent}")
    @ApiOperation(value = "查询行政区划数据", notes = "根据上级行政区划编码查询行政区划数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent", value = "上级行政区划编码", example = "CN0001")
    })
    public Result<List<RegionInfoRespDTO>> listRegionInfoByParent(@PathVariable("parent") String parent) {
        return Results.success(regionInfoService.listRegionInfoByParent(parent));
    }
}
