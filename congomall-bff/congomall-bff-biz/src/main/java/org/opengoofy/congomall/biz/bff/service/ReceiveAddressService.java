

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.dto.req.adapter.ReceiveAddressSaveAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ReceiveAddressUpdateAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.ReceiveAddressAdapterRespDTO;

import java.util.List;

/**
 * 用户收货地址
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ReceiveAddressService {
    
    /**
     * 根据用户 ID 查询收货地址
     *
     * @param customerUserId 用户 ID
     * @return 用户收货地址集合
     */
    List<ReceiveAddressAdapterRespDTO> listReceiveAddressByCustomerUserId(String customerUserId);
    
    /**
     * 新增用户收货地址
     *
     * @param requestParam 新增收货地址请求参数
     */
    Integer saveReceiveAddress(ReceiveAddressSaveAdapterReqDTO requestParam);
    
    /**
     * 根据用户 ID、收货地址 ID 删除收货地址
     *
     * @param userId 用户 ID
     * @param receiveAddressId 收货地址 ID
     */
    Integer removeReceiveAddress(String userId, String receiveAddressId);
    
    /**
     * 修改收货地址
     *
     * @param requestParam 修改收货地址请求参数
     */
    Integer updateReceiveAddress(ReceiveAddressUpdateAdapterReqDTO requestParam);
}
