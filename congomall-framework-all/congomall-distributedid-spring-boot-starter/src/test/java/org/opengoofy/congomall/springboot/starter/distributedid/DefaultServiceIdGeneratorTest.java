

package org.opengoofy.congomall.springboot.starter.distributedid;

import org.junit.Test;
import org.opengoofy.congomall.springboot.starter.distributedid.core.serviceid.DefaultServiceIdGenerator;
import org.opengoofy.congomall.springboot.starter.distributedid.core.serviceid.ServiceIdGenerator;
import org.opengoofy.congomall.springboot.starter.distributedid.core.snowflake.Snowflake;
import org.opengoofy.congomall.springboot.starter.distributedid.core.snowflake.SnowflakeIdInfo;
import org.opengoofy.congomall.springboot.starter.distributedid.handler.IdGeneratorManager;

public class DefaultServiceIdGeneratorTest {
    
    @Test
    public void nextId() {
        Snowflake snowflake = new Snowflake(0, 0);
        SnowflakeIdUtil.initSnowflake(snowflake);
        for (int i = 0; i < 100; i++) {
            long nextId = SnowflakeIdUtil.nextId();
            ServiceIdGenerator idGenerator = IdGeneratorManager.getDefaultServiceIdGenerator();
            long serviceId = idGenerator.nextId(nextId);
            System.out.println(String.format("雪花算法ID: %d, 业务ID: %d", nextId, serviceId));
            SnowflakeIdInfo snowflakeIdInfo = idGenerator.parseSnowflakeId(serviceId);
            System.out.println(snowflakeIdInfo);
        }
    }
    
    @Test
    public void parseSnowflakeId() {
        Snowflake snowflake = new Snowflake(0, 0);
        SnowflakeIdUtil.initSnowflake(snowflake);
        DefaultServiceIdGenerator defaultServiceIdGenerator = new DefaultServiceIdGenerator();
        long nextId = defaultServiceIdGenerator.nextId();
        SnowflakeIdInfo snowflakeIdInfo = defaultServiceIdGenerator.parseSnowflakeId(nextId);
        System.out.println(snowflakeIdInfo);
    }
    
    @Test
    public void nextIdParseSnowflakeId() {
        Snowflake snowflake = new Snowflake(0, 0);
        SnowflakeIdUtil.initSnowflake(snowflake);
        DefaultServiceIdGenerator defaultServiceIdGenerator = new DefaultServiceIdGenerator();
        long nextId = defaultServiceIdGenerator.nextId(1477055850177290216L);
        System.out.println(nextId);
        SnowflakeIdInfo snowflakeIdInfo = defaultServiceIdGenerator.parseSnowflakeId(nextId);
        System.out.println(snowflakeIdInfo.getGene());
    }
    
    @Test
    public void parseSnowflakeServiceId() {
        SnowflakeIdInfo snowflakeIdInfo = SnowflakeIdUtil.parseSnowflakeServiceId(String.valueOf(1634852818433081360L));
        System.out.println(snowflakeIdInfo);
    }
}
