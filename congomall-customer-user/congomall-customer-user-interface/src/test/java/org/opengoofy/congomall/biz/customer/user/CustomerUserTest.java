

package org.opengoofy.congomall.biz.customer.user;

import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity.CustomerUserDO;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.mapper.CustomerUserRepositoryMapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

/**
 * C 端用户测试用例
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@SpringBootApplication
public class CustomerUserTest {
    
    private CustomerUserRepositoryMapper customerUserRepositoryMapper;
    
    @Before
    public void before() {
        ConfigurableApplicationContext context = SpringApplication.run(CustomerUserTest.class);
        customerUserRepositoryMapper = context.getBean(CustomerUserRepositoryMapper.class);
    }
    
    @Test
    public void assertUpdateCustomerUserTest() {
        CustomerUserDO saveCustomerUserDO = new CustomerUserDO();
        saveCustomerUserDO.setName(" JavaEdge");
        saveCustomerUserDO.setAccountNumber("xiao-ma-ge");
        saveCustomerUserDO.setPassword("xiao-ma-ge");
        saveCustomerUserDO.setPhone("15601166692");
        saveCustomerUserDO.setMail("m7798432@163.com");
        saveCustomerUserDO.setAge(18);
        saveCustomerUserDO.setGender(0);
        saveCustomerUserDO.setAvatar("https://oss.aliyun.com/images");
        saveCustomerUserDO.setCreateTime(new Date());
        saveCustomerUserDO.setUpdateTime(new Date());
        saveCustomerUserDO.setDelFlag(0);
        customerUserRepositoryMapper.insert(saveCustomerUserDO);
        LambdaUpdateWrapper<CustomerUserDO> updateWrapper = Wrappers.lambdaUpdate(CustomerUserDO.class)
                .set(CustomerUserDO::getAvatar, null)
                .eq(CustomerUserDO::getId, saveCustomerUserDO.getId());
        customerUserRepositoryMapper.update(null, updateWrapper);
    }
}
