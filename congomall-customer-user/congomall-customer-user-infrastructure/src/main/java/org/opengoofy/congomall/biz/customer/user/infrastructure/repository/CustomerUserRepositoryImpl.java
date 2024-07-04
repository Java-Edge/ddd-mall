

package org.opengoofy.congomall.biz.customer.user.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import org.opengoofy.congomall.biz.customer.user.domain.event.OperationLogEvent;
import org.opengoofy.congomall.biz.customer.user.domain.repository.CustomerUserRepository;
import org.opengoofy.congomall.biz.customer.user.domain.dto.CustomerUserDTO;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity.OperationLogDO;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity.CustomerUserDO;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.mapper.OperationLogMapper;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.mapper.CustomerUserRepositoryMapper;
import org.opengoofy.congomall.biz.customer.user.infrastructure.converter.CustomerUserConverter;
import org.opengoofy.congomall.biz.customer.user.infrastructure.mq.produce.CustomerUserOperationLogProduce;
import org.opengoofy.congomall.springboot.starter.convention.errorcode.BaseErrorCode;
import org.opengoofy.congomall.springboot.starter.convention.exception.ServiceException;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * C 端用户仓储层实现
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Repository
@AllArgsConstructor
public class CustomerUserRepositoryImpl implements CustomerUserRepository {
    
    private final CustomerUserRepositoryMapper customerUserRepositoryMapper;
    
    private final CustomerUserConverter customerUserConverter;
    
    private final CustomerUserOperationLogProduce customerUserOperationLogProduce;
    
    private final OperationLogMapper operationLogMapper;
    
    @Override
    public CustomerUser find(Long customerUserId) {
        CustomerUserDO customerUserDO = customerUserRepositoryMapper.selectById(customerUserId);
        return customerUserConverter.doToCustomerUser(customerUserDO);
    }
    
    @Override
    public CustomerUser findByMail(String mail) {
        LambdaQueryWrapper<CustomerUserDO> queryWrapper = Wrappers.lambdaQuery(CustomerUserDO.class).eq(CustomerUserDO::getMail, mail);
        CustomerUserDO customerUserDO = customerUserRepositoryMapper.selectOne(queryWrapper);
        return customerUserConverter.doToCustomerUser(customerUserDO);
    }
    
    @Override
    public CustomerUser findByAccountNumber(String accountNumber) {
        LambdaQueryWrapper<CustomerUserDO> queryWrapper = Wrappers.lambdaQuery(CustomerUserDO.class).eq(CustomerUserDO::getAccountNumber, accountNumber);
        CustomerUserDO customerUserDO = customerUserRepositoryMapper.selectOne(queryWrapper);
        return customerUserConverter.doToCustomerUser(customerUserDO);
    }
    
    @Override
    public CustomerUser register(CustomerUser customerUser) {
        CustomerUserDO customerUserDO = customerUserConverter.customerUserToDO(customerUser);
        int insert = customerUserRepositoryMapper.insert(customerUserDO);
        if (insert < 1) {
            throw new ServiceException(BaseErrorCode.USER_REGISTER_ERROR);
        }
        Long customerUserId = customerUserDO.getId();
        // 异步记录操作日志
        customerUserOperationLogProduce.recordCustomerUserOperationLog(new OperationLogEvent(BeanUtil.toBean(customerUserDO, CustomerUserDTO.class)));
        return find(customerUserId);
    }
    
    @Override
    public void saveOperationLog(CustomerUser customerUser) {
        OperationLogEvent customerOperationLogEvent = customerUser.getOperationLogEvent();
        OperationLogDO operationLogDO = new OperationLogDO(JSON.toJSONString(customerOperationLogEvent.getAfterCustomerUser()));
        if (customerOperationLogEvent.getBeforeCustomerUser() != null) {
            operationLogDO.setBeforeContent(JSON.toJSONString(customerOperationLogEvent.getBeforeCustomerUser()));
        }
        operationLogDO.setCustomerUserId(customerUser.getCustomerUserId());
        operationLogMapper.insert(operationLogDO);
    }
}
