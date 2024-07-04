

package org.opengoofy.congomall.biz.message.infrastructure.algorithm;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.opengoofy.congomall.springboot.starter.distributedid.SnowflakeIdUtil;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 自定义分片算法
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class SnowflakeDateShardingAlgorithm implements ComplexKeysShardingAlgorithm<Date> {
    
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        final String messageSendId = "msg_id";
        final String sendTime = "create_time";
        String logicTableName = shardingValue.getLogicTableName();
        Map<String, Collection<Comparable<?>>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        Map<String, Range<Comparable<?>>> columnNameAndRangeValuesMap = shardingValue.getColumnNameAndRangeValuesMap();
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        if (CollUtil.isNotEmpty(columnNameAndShardingValuesMap)) {
            Collection<Comparable<?>> sendTimeCollection = columnNameAndShardingValuesMap.get(sendTime);
            if (CollUtil.isNotEmpty(sendTimeCollection)) {
                Comparable<?> comparable = sendTimeCollection.stream().findFirst().get();
                String actualTable = ShardModel.quarterlyModel(logicTableName, (Date) comparable);
                result.add(actualTable);
            } else {
                Collection<Comparable<?>> messageSendIdCollection = columnNameAndShardingValuesMap.get(messageSendId);
                Comparable<?> comparable = messageSendIdCollection.stream().findFirst().get();
                String actualTable = ShardModel.quarterlyModel(logicTableName, new Date(SnowflakeIdUtil.parseSnowflakeId(((Long) comparable)).getTimestamp()));
                result.add(actualTable);
            }
        } else {
            Range<Comparable<?>> sendTimeRange = columnNameAndRangeValuesMap.get(sendTime);
            if (sendTimeRange != null) {
                List<String> actualTables = ShardModel.calculateRange(logicTableName, (Date) sendTimeRange.lowerEndpoint(), (Date) sendTimeRange.upperEndpoint());
                result.addAll(actualTables);
            } else {
                result.addAll(availableTargetNames);
            }
        }
        return result;
    }
    
    @Override
    public Properties getProps() {
        return null;
    }
    
    @Override
    public void init(Properties properties) {
        
    }
    
    @Override
    public String getType() {
        return "CLASS_BASED";
    }
}
