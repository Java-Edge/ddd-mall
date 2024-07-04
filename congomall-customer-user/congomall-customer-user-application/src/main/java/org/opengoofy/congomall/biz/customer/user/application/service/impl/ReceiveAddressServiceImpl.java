

package org.opengoofy.congomall.biz.customer.user.application.service.impl;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.ReceiveAddressSaveCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.ReceiveAddressUpdateCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.ReceiveAddressRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.service.ReceiveAddressService;
import org.opengoofy.congomall.biz.customer.user.domain.mode.ReceiveAddress;
import org.opengoofy.congomall.biz.customer.user.domain.repository.ReceiveAddressRepository;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户收货地址
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@AllArgsConstructor
public class ReceiveAddressServiceImpl implements ReceiveAddressService {
    
    private final ReceiveAddressRepository receiveAddressRepository;
    
    @Override
    public List<ReceiveAddressRespDTO> listReceiveAddressByCustomerUserId(String customerUserId) {
        List<ReceiveAddress> receiveAddresses = receiveAddressRepository.listReceiveAddressByCustomerUserId(customerUserId);
        return BeanUtil.convert(receiveAddresses, ReceiveAddressRespDTO.class);
    }
    
    @Override
    public void saveReceiveAddress(ReceiveAddressSaveCommand requestParam) {
        ReceiveAddress receiveAddress = BeanUtil.convert(requestParam, ReceiveAddress.class);
        receiveAddressRepository.saveReceiveAddress(receiveAddress);
    }
    
    @Override
    public void removeReceiveAddress(String customerUserId, String receiveAddressId) {
        receiveAddressRepository.removeReceiveAddress(customerUserId, receiveAddressId);
    }
    
    @Override
    public void updateReceiveAddress(ReceiveAddressUpdateCommand requestParam) {
        ReceiveAddress receiveAddress = BeanUtil.convert(requestParam, ReceiveAddress.class);
        receiveAddressRepository.updateReceiveAddress(receiveAddress);
    }
}
