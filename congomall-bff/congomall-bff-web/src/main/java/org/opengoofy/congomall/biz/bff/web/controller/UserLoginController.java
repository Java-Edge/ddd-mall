

package org.opengoofy.congomall.biz.bff.web.controller;

import com.alibaba.fastjson2.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.common.ResultT;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.UserLoginAdapterRepDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.UserLoginAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.service.UserLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "用户登录")
public class UserLoginController {
    
    private final UserLoginService userLoginService;
    
    @GetMapping("/member/checkLogin")
    @ApiOperation(value = "检查用户是否登录", notes = "根据Token检查用户是否登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户登录Token", required = true, example = "JWT Token")
    })
    public ResultT<UserLoginAdapterRespDTO> checkLogin(@RequestParam(value = "token", required = false) String token) {
        UserLoginAdapterRespDTO result = userLoginService.checkLogin(token);
        return ResultT.success(result);
    }
    
    @PostMapping("/member/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ResultT<UserLoginAdapterRespDTO> login(@RequestBody UserLoginAdapterRepDTO requestParam) {
        UserLoginAdapterRespDTO result = userLoginService.login(requestParam);
        return ResultT.success(result);
    }
    
    @GetMapping("/member/geetestInit")
    @ApiOperation(value = "初始化极验验证码", notes = "初始化极验验证码")
    public String geeTestInit() {
        return JSON.toJSONString(userLoginService.initGeeTestConfig());
    }
    
    @GetMapping("/member/loginOut")
    @ApiOperation(value = "用户退出登录", notes = "用户退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "用户Token", required = true, example = "JWT Token")
    })
    public ResultT<Void> logout(@RequestParam(value = "token", required = false) String token) {
        userLoginService.logout(token);
        return ResultT.success();
    }
}
