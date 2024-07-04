

package org.opengoofy.congomall.biz.product.infrastructure.algorithm;

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
 * 基因雪花算法实现，brand_id 作为 product_id 的一部分
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class ProductSkuSnowflakeServiceShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {
    
    @Getter
    private Properties props;
    private int shardingCount;
    private static final String SHARDING_COUNT_KEY = "sharding-count";
    
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        final String brandId = "brand_id";
        final String productId = "product_id";
        Map<String, Collection<Comparable<Long>>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        if (CollUtil.isNotEmpty(columnNameAndShardingValuesMap)) {
            Collection<Comparable<Long>> brandIdCollection = columnNameAndShardingValuesMap.get(brandId);
            if (CollUtil.isNotEmpty(brandIdCollection)) {
                Comparable<?> comparable = brandIdCollection.stream().findFirst().get();
                String tableNameSuffix = String.valueOf(hashShardingValue(comparable) % shardingCount);
                result.add(shardingValue.getLogicTableName() + "_" + tableNameSuffix);
            } else {
                Collection<Comparable<Long>> productIdCollection = columnNameAndShardingValuesMap.get(productId);
                Comparable<Long> comparable = productIdCollection.stream().findFirst().get();
                int tableNameSuffix = SnowflakeIdUtil.parseSnowflakeServiceId(String.valueOf(comparable)).getGene();
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
