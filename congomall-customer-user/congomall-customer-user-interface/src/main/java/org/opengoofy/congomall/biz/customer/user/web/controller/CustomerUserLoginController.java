package org.opengoofy.congomall.biz.customer.user.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.UserLoginCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.service.CustomerUserService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * C端用户登录控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "C端用户登录")
public class CustomerUserLoginController {
    
    private final CustomerUserService customerUserService;
    
    @GetMapping("/api/customer-user/check-login")
    @ApiOperation(value = "检查用户是否登录", notes = "通过Token检查用户是否登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "用户Token", required = true, example = "JWT Token")
    })
    public Result<UserLoginRespDTO> checkLogin(@RequestParam("accessToken") String accessToken) {
        UserLoginRespDTO result = customerUserService.checkLogin(accessToken);
        return Results.success(result);
    }
    
    @PostMapping("/api/customer-user/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public Result<UserLoginRespDTO> login(@RequestBody @Valid UserLoginCommand requestParam) {
        UserLoginRespDTO result = customerUserService.login(requestParam);
        return Results.success(result);
    }
    
    @GetMapping("/api/customer-user/logout")
    @ApiOperation(value = "用户退出登录", notes = "用户退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "用户Token", required = true, example = "JWT Token")
    })
    public Result<Void> logout(@RequestParam(required = false) String accessToken) {
        customerUserService.logout(accessToken);
        return Results.success();
    }
}