

package org.opengoofy.congomall.biz.bff.remote;

import org.opengoofy.congomall.biz.bff.remote.req.ReceiveAddressSaveCommand;
import org.opengoofy.congomall.biz.bff.remote.req.ReceiveAddressUpdateCommand;
import org.opengoofy.congomall.biz.bff.remote.req.UserLoginCommand;
import org.opengoofy.congomall.biz.bff.remote.resp.ReceiveAddressRespDTO;
import org.opengoofy.congomall.biz.bff.remote.resp.UserLoginRespDTO;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * C端用户远程服务调用
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@FeignClient(value = "customer-user-service", url = "${congomall.aggregation.remote-url:}")
public interface CustomerUserRemoteService {
    
    /**
     * 用户登录
     */
    @PostMapping("/api/customer-user/login")
    Result<UserLoginRespDTO> login(@RequestBody UserLoginCommand requestParam);
    
    /**
     * 检查用户是否登录
     */
    @GetMapping("/api/customer-user/check-login")
    Result<UserLoginRespDTO> checkLogin(@RequestParam("accessToken") String accessToken);
    
    /**
     * 用户退出登录
     */
    @GetMapping("/api/customer-user/logout")
    Result<Void> logout(@RequestParam("accessToken") String accessToken);
    
    /**
     * 根据用户 ID 查询收货地址
     */
    @GetMapping("/api/customer-user/receive-address/{customerUserId}")
    Result<List<ReceiveAddressRespDTO>> listReceiveAddress(@PathVariable("customerUserId") String customerUserId);
    
    /**
     * 新增用户收货地址
     */
    @PostMapping("/api/customer-user/receive-address")
    Result<Void> saveReceiveAddress(@RequestBody ReceiveAddressSaveCommand requestParam);
    
    /**
     * 修改用户收货地址
     */
    @PutMapping("/api/customer-user/receive-address")
    Result<Void> updateReceiveAddress(@RequestBody ReceiveAddressUpdateCommand requestParam);
    
    /**
     * 删除用户收货地址
     */
    @DeleteMapping("/api/customer-user/{customerUserId}/receive-address/{receiveAddressId}")
    Result<Void> removeReceiveAddress(@PathVariable("customerUserId") String customerUserId, @PathVariable("receiveAddressId") String receiveAddressId);
}
