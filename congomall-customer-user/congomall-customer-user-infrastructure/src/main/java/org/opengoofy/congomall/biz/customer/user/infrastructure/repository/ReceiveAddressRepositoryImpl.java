

package org.opengoofy.congomall.biz.customer.user.infrastructure.repository;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.domain.mode.ReceiveAddress;
import org.opengoofy.congomall.biz.customer.user.domain.repository.ReceiveAddressRepository;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.mapper.ReceiveAddressMapper;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity.ReceiveAddressDO;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户收货地址仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Repository
@AllArgsConstructor
public class ReceiveAddressRepositoryImpl implements ReceiveAddressRepository {
    
    private final ReceiveAddressMapper receiveAddressMapper;
    
    @Override
    public List<ReceiveAddress> listReceiveAddressByCustomerUserId(String customerUserId) {
        List<ReceiveAddressDO> receiveAddressDOList = receiveAddressMapper.selectList(Wrappers.lambdaQuery(ReceiveAddressDO.class).eq(ReceiveAddressDO::getCustomerUserId, customerUserId));
        return BeanUtil.convert(receiveAddressDOList, ReceiveAddress.class);
    }
    
    @Override
    public void saveReceiveAddress(ReceiveAddress receiveAddress) {
        ReceiveAddressDO receiveAddressDO = BeanUtil.convert(receiveAddress, ReceiveAddressDO.class);
        receiveAddressMapper.insert(receiveAddressDO);
    }
    
    @Override
    public void removeReceiveAddress(String customerUserId, String receiveAddressId) {
        LambdaUpdateWrapper<ReceiveAddressDO> updateWrapper = Wrappers.lambdaUpdate(ReceiveAddressDO.class)
                .eq(ReceiveAddressDO::getCustomerUserId, customerUserId)
                .eq(ReceiveAddressDO::getId, receiveAddressId);
        receiveAddressMapper.delete(updateWrapper);
    }
    
    @Override
    public void updateReceiveAddress(ReceiveAddress receiveAddress) {
        LambdaUpdateWrapper<ReceiveAddressDO> updateWrapper = Wrappers.lambdaUpdate(ReceiveAddressDO.class)
                .eq(ReceiveAddressDO::getCustomerUserId, receiveAddress.getCustomerUserId())
                .eq(ReceiveAddressDO::getId, receiveAddress.getId());
        ReceiveAddressDO receiveAddressDO = BeanUtil.convert(receiveAddress, ReceiveAddressDO.class);
        receiveAddressMapper.update(receiveAddressDO, updateWrapper);
    }
}
