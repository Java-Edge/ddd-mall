package org.opengoofy.congomall.biz.message.test;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opengoofy.congomall.biz.message.infrastructure.dao.entity.SendRecordDO;
import org.opengoofy.congomall.biz.message.infrastructure.dao.mapper.SendRecordMapper;
import org.opengoofy.congomall.biz.message.web.MessageApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义复合分片算法单元测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageApplication.class)
public class SnowflakeDateShardingAlgorithmTest {
    
    @Resource
    private SendRecordMapper sendRecordMapper;
    
    @Test
    public void testSendTimeQuery() {
        LambdaQueryWrapper<SendRecordDO> queryWrapper = Wrappers.lambdaQuery(SendRecordDO.class)
                .eq(SendRecordDO::getSendTime, DateUtil.now());
        executeQuery(queryWrapper);
    }
    
    @Test
    public void testSnowflakeQuery() {
        LambdaQueryWrapper<SendRecordDO> queryWrapper = Wrappers.lambdaQuery(SendRecordDO.class)
                .eq(SendRecordDO::getMessageSendId, 1547434279292878848L);
        executeQuery(queryWrapper);
    }
    
    @Test
    public void testBetweenQuery() {
        LambdaQueryWrapper<SendRecordDO> queryWrapper = Wrappers.lambdaQuery(SendRecordDO.class)
                .between(SendRecordDO::getSendTime, DateUtil.parse("2023-07-14 12:12:18"), DateUtil.parse("2024-08-14 12:15:18"));
        executeQuery(queryWrapper);
    }
    
    private void executeQuery(LambdaQueryWrapper queryWrapper) {
        List<SendRecordDO> sendRecords = sendRecordMapper.selectList(queryWrapper);
        log.info("sendRecords: {}", JSON.toJSONString(sendRecords));
    }
}