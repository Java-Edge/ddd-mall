

package org.opengoofy.congomall.biz.bff.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.opengoofy.congomall.biz.bff.common.SentinelLimitFlowConstant;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化限流配置
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Component
public class SentinelRuleConfig implements InitializingBean {
    
    @Value("${congomall.bff.qps-count:1}")
    private Integer qpsCount;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule createOrderRule = new FlowRule();
        createOrderRule.setResource(SentinelLimitFlowConstant.CREATE_ORDER_PATH);
        createOrderRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        createOrderRule.setCount(qpsCount);
        FlowRule addCartRule = new FlowRule();
        addCartRule.setResource(SentinelLimitFlowConstant.ADD_CART_PATH);
        addCartRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        addCartRule.setCount(qpsCount);
        FlowRule addAddressRule = new FlowRule();
        addAddressRule.setResource(SentinelLimitFlowConstant.ADD_ADDRESS_PATH);
        addAddressRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        addAddressRule.setCount(qpsCount);
        rules.add(createOrderRule);
        rules.add(addCartRule);
        rules.add(addAddressRule);
        FlowRuleManager.loadRules(rules);
    }
}
