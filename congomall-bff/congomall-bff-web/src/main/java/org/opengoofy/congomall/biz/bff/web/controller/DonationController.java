

package org.opengoofy.congomall.biz.bff.web.controller;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.common.PageAdapter;
import org.opengoofy.congomall.biz.bff.common.ResultT;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.DonationAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomePanelAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.service.DonationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 捐赠服务控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "捐赠服务")
public class DonationController {
    
    private final DonationService donationService;
    
    @GetMapping("/member/thanks")
    @ApiOperation(value = "用户捐赠列表", notes = "用户捐赠列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "用户捐赠类表第几页", required = true, example = "1"),
            @ApiImplicitParam(name = "size", value = "用户捐赠类表每页多少条数据", required = true, example = "10")
    })
    public ResultT<PageAdapter<List<DonationAdapterRespDTO>>> pageQueryDonation(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return ResultT.success(donationService.pageQueryDonation(page, size));
    }
    
    @GetMapping("/goods/thank")
    @ApiOperation(value = "用户捐赠板块", notes = "用户捐赠板块")
    public ResultT<List<HomePanelAdapterRespDTO>> queryDonation() {
        return ResultT.success(Lists.newArrayList(donationService.queryDonation()));
    }
}
