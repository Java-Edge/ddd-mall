package org.opengoofy.congomall.springboot.starter.cache;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * 分布式缓存测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@SpringBootApplication
public class DistributedCacheTest {
    
    private DistributedCache distributedCache;
    
    @Before
    public void before() {
        ConfigurableApplicationContext context = SpringApplication.run(DistributedCacheTest.class);
        distributedCache = context.getBean(DistributedCache.class);
    }
    
    @Test
    public void assertSafePut() {
        distributedCache.safePut("test", "test_value", 5000L, null);
        String actual = distributedCache.get("test", String.class);
        Assert.assertEquals(actual, "test_value");
    }
    
    @Test
    public void assertSecureGet() {
        distributedCache.safeGet("test", String.class, () -> "test_value", 5000L);
        String actual = distributedCache.get("test", String.class);
        Assert.assertEquals(actual, "test_value");
    }
    
    @Test
    public void assertBloomFilterSecureGet() {
        for (int i = 0; i < 2; i++) {
            distributedCache.safeGet("test", String.class, () -> "", 5000L);
        }
    }
    
    @Test
    public void assertPutIfAllAbsent() {
        List<String> keys = Lists.newArrayList("name", "age");
        Boolean result = distributedCache.putIfAllAbsent(keys);
        Assert.assertTrue(result);
        keys.forEach(each -> {
            String name = distributedCache.get("name", String.class);
            Assert.assertEquals(name, "default");
        });
        Boolean resultFalse = distributedCache.putIfAllAbsent(keys);
        Assert.assertFalse(resultFalse);
    }
}