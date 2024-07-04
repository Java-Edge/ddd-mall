

package org.opengoofy.congomall.biz.customer.user.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.UserRegisterCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserRegisterRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.service.CustomerUserService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * C端用户控制层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@MLog
@RestController
@AllArgsConstructor
@Api(tags = "C端用户")
public class CustomerUserController {
    
    private final CustomerUserService customerUserService;
    
    @PostMapping("/api/customer-user/verify/code/send")
    @ApiOperation(value = "验证发送", notes = "包含注册验证码、登录验证等")
    public Result<Void> verifyCodeSend(@RequestBody @Valid UserVerifyCodeCommand requestParam) {
        customerUserService.verifyCodeSend(requestParam);
        return Results.success();
    }
    
    @PostMapping("/api/customer-user/register")
    @ApiOperation(value = "注册用户", notes = "注册C端用户账号")
    public Result<UserRegisterRespDTO> register(@RequestBody @Valid UserRegisterCommand requestParam) {
        UserRegisterRespDTO result = customerUserService.register(requestParam);
        return Results.success(result);
    }
}
