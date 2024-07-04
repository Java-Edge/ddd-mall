

package org.opengoofy.congomall.biz.order.infrastructure.repository;

import cn.hutool.core.text.StrBuilder;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opengoofy.congomall.biz.order.domain.aggregate.CneeInfo;
import org.opengoofy.congomall.biz.order.domain.aggregate.Order;
import org.opengoofy.congomall.biz.order.domain.aggregate.OrderProduct;
import org.opengoofy.congomall.biz.order.domain.common.OrderCanalErrorCodeEnum;
import org.opengoofy.congomall.biz.order.domain.common.OrderStatusEnum;
import org.opengoofy.congomall.biz.order.domain.repository.OrderRepository;
import org.opengoofy.congomall.biz.order.infrastructure.dao.entity.OrderDO;
import org.opengoofy.congomall.biz.order.infrastructure.dao.entity.OrderItemDO;
import org.opengoofy.congomall.biz.order.infrastructure.dao.mapper.OrderItemMapper;
import org.opengoofy.congomall.biz.order.infrastructure.dao.mapper.OrderMapper;
import org.opengoofy.congomall.mybatisplus.springboot.starter.PageUtil;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import org.opengoofy.congomall.springboot.starter.convention.exception.ServiceException;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;
import org.opengoofy.congomall.springboot.starter.distributedid.SnowflakeIdUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final RedissonClient redissonClient;
    
    @Override
    public Order findOrderByOrderSn(String orderSn) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        OrderDO orderDO = orderMapper.selectOne(queryWrapper);
        Order resultOrder = BeanUtil.convert(orderDO, Order.class);
        resultOrder.setCneeInfo(BeanUtil.convert(orderDO, CneeInfo.class));
        LambdaQueryWrapper<OrderItemDO> lambdaQueryWrapper = Wrappers.lambdaQuery(OrderItemDO.class)
                .eq(OrderItemDO::getOrderSn, resultOrder.getOrderSn());
        List<OrderItemDO> orderItemList = orderItemMapper.selectList(lambdaQueryWrapper);
        resultOrder.setOrderProducts(BeanUtil.convert(orderItemList, OrderProduct.class));
        return resultOrder;
    }
    
    @Override
    public List<Order> findOrderByCustomerUserId(String customerUserId) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getCustomerUserId, customerUserId)
                .orderByDesc(OrderDO::getCreateTime);
        List<OrderDO> orderDOList = orderMapper.selectList(queryWrapper);
        List<Order> resultOrder = BeanUtil.convert(orderDOList, Order.class);
        resultOrder.forEach(each -> {
            LambdaQueryWrapper<OrderItemDO> lambdaQueryWrapper = Wrappers.lambdaQuery(OrderItemDO.class)
                    .eq(OrderItemDO::getOrderSn, each.getOrderSn());
            List<OrderItemDO> orderItemList = orderItemMapper.selectList(lambdaQueryWrapper);
            each.setOrderProducts(BeanUtil.convert(orderItemList, OrderProduct.class));
        });
        return resultOrder;
    }
    
    @Override
    public void createOrder(Order order) {
        long orderId = SnowflakeIdUtil.nextId();
        OrderDO orderDO = BeanUtil.convert(order, OrderDO.class);
        orderDO.setId(orderId);
        BeanUtil.convertIgnoreNullAndBlank(order.getCneeInfo(), orderDO);
        orderMapper.insert(orderDO);
        List<OrderItemDO> orderItemDOList = BeanUtil.convert(order.getOrderProducts(), OrderItemDO.class);
        orderItemDOList.forEach(each -> each.setOrderId(orderId).setCustomerUserId(order.getCustomerUserId()));
        orderItemDOList.forEach(orderItemMapper::insert);
    }
    
    @Override
    public void closeOrder(String orderSn) {
        OrderDO updateOrderDO = new OrderDO();
        updateOrderDO.setStatus(OrderStatusEnum.CLOSED.getStatus());
        LambdaUpdateWrapper<OrderDO> updateWrapper = Wrappers.lambdaUpdate(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        orderMapper.update(updateOrderDO, updateWrapper);
    }
    
    @Override
    public void canalOrder(String orderSn) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        OrderDO orderDO = orderMapper.selectOne(queryWrapper);
        if (orderDO == null) {
            throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_CANAL_UNKNOWN_ERROR);
        } else if (orderDO.getStatus() != OrderStatusEnum.PENDING_PAYMENT.getStatus()) {
            throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_CANAL_STATUS_ERROR);
        }
        RLock lock = redissonClient.getLock(StrBuilder.create("order:canal:order_sn_").append(orderSn).toString());
        if (!lock.tryLock()) {
            throw new ClientException(OrderCanalErrorCodeEnum.ORDER_CANAL_REPETITION_ERROR);
        }
        try {
            OrderDO updateOrderDO = new OrderDO();
            updateOrderDO.setStatus(OrderStatusEnum.CLOSED.getStatus());
            updateOrderDO.setOrderSn(orderSn);
            LambdaUpdateWrapper<OrderDO> updateWrapper = Wrappers.lambdaUpdate(OrderDO.class)
                    .eq(OrderDO::getOrderSn, orderSn);
            int updateResult = orderMapper.update(updateOrderDO, updateWrapper);
            if (updateResult <= 0) {
                throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_CANAL_ERROR);
            }
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public void statusReversal(Order order) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getOrderSn, order.getOrderSn());
        OrderDO orderDO = orderMapper.selectOne(queryWrapper);
        if (orderDO == null) {
            throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_CANAL_UNKNOWN_ERROR);
        } else if (orderDO.getStatus() != OrderStatusEnum.PENDING_PAYMENT.getStatus()) {
            throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_CANAL_STATUS_ERROR);
        }
        RLock lock = redissonClient.getLock(StrBuilder.create("order:status-reversal:order_sn_").append(order.getOrderSn()).toString());
        if (!lock.tryLock()) {
            log.warn("订单重复修改状态，订单聚合根：{}", JSON.toJSONString(order));
        }
        try {
            OrderDO updateOrderDO = new OrderDO();
            updateOrderDO.setStatus(order.getStatus());
            LambdaUpdateWrapper<OrderDO> updateWrapper = Wrappers.lambdaUpdate(OrderDO.class)
                    .eq(OrderDO::getOrderSn, order.getOrderSn());
            int updateResult = orderMapper.update(updateOrderDO, updateWrapper);
            if (updateResult <= 0) {
                throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_STATUS_REVERSAL_ERROR);
            }
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public void deleteOrder(String orderSn) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        OrderDO orderDO = orderMapper.selectOne(queryWrapper);
        if (orderDO == null) {
            throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_CANAL_UNKNOWN_ERROR);
        }
        LambdaUpdateWrapper<OrderDO> updateWrapper = Wrappers.lambdaUpdate(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        int updateResult = orderMapper.delete(updateWrapper);
        if (updateResult <= 0) {
            throw new ServiceException(OrderCanalErrorCodeEnum.ORDER_DELETE_ERROR);
        }
    }
    
    @Override
    public PageResponse<Order> pageQueryOrder(String userId, PageRequest pageRequest) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class).eq(OrderDO::getCustomerUserId, userId);
        Page<OrderDO> orderDOPage = orderMapper.selectPage(new Page<>(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        PageResponse<Order> actualResult = PageUtil.convert(orderDOPage, Order.class);
        actualResult.convert(each -> {
            LambdaQueryWrapper<OrderItemDO> lambdaQueryWrapper = Wrappers.lambdaQuery(OrderItemDO.class)
                    .eq(OrderItemDO::getOrderSn, each.getOrderSn());
            List<OrderItemDO> orderItemList = orderItemMapper.selectList(lambdaQueryWrapper);
            each.setOrderProducts(BeanUtil.convert(orderItemList, OrderProduct.class));
            return each;
        });
        return actualResult;
    }
}
