

package org.opengoofy.congomall.biz.order.infrastructure.algorithm;

import cn.hutool.core.collection.CollUtil;
import com.google.common.base.Preconditions;
import lombok.Getter;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.opengoofy.congomall.springboot.starter.distributedid.SnowflakeIdUtil;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;

/**
 * 基因雪花算法实现，customer_user_id 作为 order_sn 的一部分
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class OrderSnowflakeServiceShardingAlgorithm implements ComplexKeysShardingAlgorithm {
    
    @Getter
    private Properties props;
    
    private int shardingCount;
    
    private static final String SHARDING_COUNT_KEY = "sharding-count";
    
    private final String customerUserId = "customer_user_id";
    
    private final String orderSn = "order_sn";
    
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Map<String, Collection<Comparable<?>>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        if (CollUtil.isNotEmpty(columnNameAndShardingValuesMap)) {
            Collection<Comparable<?>> customerUserIdCollection = columnNameAndShardingValuesMap.get(customerUserId);
            if (CollUtil.isNotEmpty(customerUserIdCollection)) {
                Comparable<?> comparable = customerUserIdCollection.stream().findFirst().get();
                String tableNameSuffix = String.valueOf(hashShardingValue(comparable) % shardingCount);
                result.add(shardingValue.getLogicTableName() + "_" + tableNameSuffix);
            } else {
                Collection<Comparable<?>> orderSnCollection = columnNameAndShardingValuesMap.get(orderSn);
                Comparable<?> comparable = orderSnCollection.stream().findFirst().get();
                int tableNameSuffix = SnowflakeIdUtil.parseSnowflakeServiceId((String) comparable).getGene();
                result.add(shardingValue.getLogicTableName() + "_" + tableNameSuffix);
            }
        }
        return result;
    }
    
    @Override
    public void init(Properties props) {
        this.props = props;
        shardingCount = getShardingCount(props);
    }
    
    private int getShardingCount(final Properties props) {
        Preconditions.checkArgument(props.containsKey(SHARDING_COUNT_KEY), "Sharding count cannot be null.");
        return Integer.parseInt(props.getProperty(SHARDING_COUNT_KEY));
    }
    
    private long hashShardingValue(final Comparable<?> shardingValue) {
        return Math.abs((long) shardingValue.hashCode());
    }
}
