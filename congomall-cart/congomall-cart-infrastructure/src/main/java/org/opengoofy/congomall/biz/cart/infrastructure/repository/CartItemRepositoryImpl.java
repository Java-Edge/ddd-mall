

package org.opengoofy.congomall.biz.cart.infrastructure.repository;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.opengoofy.congomall.biz.cart.domain.aggregate.CartItem;
import org.opengoofy.congomall.biz.cart.domain.common.SelectFlagEnum;
import org.opengoofy.congomall.biz.cart.domain.repository.CartItemRepository;
import org.opengoofy.congomall.biz.cart.infrastructure.dao.entity.CartItemDO;
import org.opengoofy.congomall.biz.cart.infrastructure.dao.mapper.CartItemMapper;
import org.opengoofy.congomall.mybatisplus.springboot.starter.PageUtil;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.exception.ServiceException;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 购物车仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Repository
@RequiredArgsConstructor
public class CartItemRepositoryImpl implements CartItemRepository {
    
    private final CartItemMapper cartItemMapper;
    private final RedissonClient redissonClient;
    
    private static final String ADD_CART_LOCK_PREFIX = "add-cart-lock_";
    
    @Value("${congomall.cart.max-product:500}")
    public Integer maxProductNum;
    
    @Override
    public PageResponse<CartItem> pageQueryCartItem(String userId, PageRequest pageRequest) {
        LambdaQueryWrapper<CartItemDO> queryWrapper = Wrappers.lambdaQuery(CartItemDO.class)
                .eq(CartItemDO::getCustomerUserId, userId);
        Page<CartItemDO> selectPage = cartItemMapper.selectPage(new Page<>(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        return PageUtil.convert(selectPage, CartItem.class);
    }
    
    @Override
    public List<CartItem> querySelectCartByCustomerUserId(String customerUserId) {
        LambdaQueryWrapper<CartItemDO> queryWrapper = Wrappers.lambdaQuery(CartItemDO.class).eq(CartItemDO::getCustomerUserId, customerUserId)
                .eq(CartItemDO::getSelectFlag, SelectFlagEnum.SELECTED.getCode());
        List<CartItemDO> selectList = cartItemMapper.selectList(queryWrapper);
        return BeanUtil.convert(selectList, CartItem.class);
    }
    
    @SneakyThrows
    @Override
    public void addCartItem(CartItem cartItem) {
        String beforeLockName = StrUtil.builder()
                .append(cartItem.getCustomerUserId())
                .append(cartItem.getProductId())
                .append(cartItem.getProductSkuId())
                .toString();
        String actualLockName = StrUtil.builder()
                .append(ADD_CART_LOCK_PREFIX)
                .append(Base64.encodeStr(beforeLockName.getBytes(), true, false))
                .toString();
        RLock lock = redissonClient.getLock(actualLockName);
        boolean tryLock = lock.tryLock(3, TimeUnit.SECONDS);
        if (!tryLock) {
            throw new ServiceException("添加购物车失败");
        }
        int countUserCartItem = countUserCartItem(String.valueOf(cartItem.getCustomerUserId()));
        if (countUserCartItem >= maxProductNum) {
            throw new ServiceException(String.format("购物车最多添加%d件商品", maxProductNum));
        }
        try {
            LambdaQueryWrapper<CartItemDO> queryWrapper = Wrappers.lambdaQuery(CartItemDO.class)
                    .eq(CartItemDO::getProductId, cartItem.getProductId())
                    .eq(CartItemDO::getProductSkuId, cartItem.getProductSkuId())
                    .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId());
            CartItemDO cartItemDO = cartItemMapper.selectOne(queryWrapper);
            if (cartItemDO != null) {
                LambdaUpdateWrapper<CartItemDO> updateWrapper = Wrappers.lambdaUpdate(CartItemDO.class)
                        .eq(CartItemDO::getProductId, cartItem.getProductId())
                        .eq(CartItemDO::getProductSkuId, cartItem.getProductSkuId())
                        .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId());
                CartItemDO updateCartItem = new CartItemDO();
                updateCartItem.setProductQuantity(cartItemDO.getProductQuantity() + cartItem.getProductQuantity());
                cartItemMapper.update(updateCartItem, updateWrapper);
            } else {
                int insertFlag = cartItemMapper.insert(BeanUtil.convert(cartItem, CartItemDO.class));
                Assert.isTrue(insertFlag > 0, () -> new ServiceException("添加购物车失败"));
            }
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public void updateCheckCartItem(CartItem cartItem) {
        LambdaUpdateWrapper<CartItemDO> updateWrapper = Wrappers.lambdaUpdate(CartItemDO.class)
                .eq(CartItemDO::getProductId, cartItem.getProductId())
                .eq(CartItemDO::getProductSkuId, cartItem.getProductSkuId())
                .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId());
        CartItemDO updateCartItem = new CartItemDO();
        updateCartItem.setSelectFlag(cartItem.getSelectFlag());
        int updateFlag = cartItemMapper.update(updateCartItem, updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("修改购物车选中状态失败"));
    }
    
    @Override
    public void updateChecksCartItem(CartItem cartItem) {
        LambdaUpdateWrapper<CartItemDO> updateWrapper = Wrappers.lambdaUpdate(CartItemDO.class)
                .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId());
        CartItemDO updateCartItem = new CartItemDO();
        updateCartItem.setSelectFlag(cartItem.getSelectFlag());
        int updateFlag = cartItemMapper.update(updateCartItem, updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("修改购物车选中状态失败"));
    }
    
    @Override
    public void updateCartItem(CartItem cartItem) {
        LambdaUpdateWrapper<CartItemDO> updateWrapper = Wrappers.lambdaUpdate(CartItemDO.class)
                .eq(CartItemDO::getProductId, cartItem.getProductId())
                .eq(CartItemDO::getProductSkuId, cartItem.getProductSkuId())
                .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId());
        CartItemDO updateCartItem = new CartItemDO();
        updateCartItem.setProductQuantity(cartItem.getProductQuantity());
        int updateFlag = cartItemMapper.update(updateCartItem, updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("修改购物车失败"));
    }
    
    @Override
    public void deleteCartItem(CartItem cartItem) {
        LambdaUpdateWrapper<CartItemDO> updateWrapper = Wrappers.lambdaUpdate(CartItemDO.class)
                .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId())
                .in(CartItemDO::getProductSkuId, cartItem.getProductSkuIds());
        int updateFlag = cartItemMapper.delete(updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("删除购物车失败"));
    }
    
    @Override
    public int countUserCartItem(String customerUserId) {
        return Optional.ofNullable(cartItemMapper.countUserCartItem(customerUserId)).orElse(0);
    }
    
    @Override
    public void deleteChecksCartItem(CartItem cartItem) {
        LambdaUpdateWrapper<CartItemDO> updateWrapper = Wrappers.lambdaUpdate(CartItemDO.class)
                .eq(CartItemDO::getCustomerUserId, cartItem.getCustomerUserId())
                .eq(CartItemDO::getSelectFlag, SelectFlagEnum.SELECTED.getCode());
        int updateFlag = cartItemMapper.delete(updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("删除购物车选中商品失败"));
    }
}
