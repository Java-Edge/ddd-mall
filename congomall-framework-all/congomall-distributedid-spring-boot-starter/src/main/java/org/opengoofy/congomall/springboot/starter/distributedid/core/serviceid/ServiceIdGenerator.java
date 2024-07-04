

package org.opengoofy.congomall.springboot.starter.distributedid.core.serviceid;

import org.opengoofy.congomall.springboot.starter.distributedid.core.IdGenerator;
import org.opengoofy.congomall.springboot.starter.distributedid.core.snowflake.SnowflakeIdInfo;

/**
 * 业务 ID 生成器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface ServiceIdGenerator extends IdGenerator {
    
    /**
     * 根据 {@param serviceId} 生成雪花算法 ID
     */
    long nextId(long serviceId);
    
    /**
     * 根据 {@param serviceId} 生成字符串类型雪花算法 ID
     */
    String nextIdStr(long serviceId);
    
    /**
     * 解析雪花算法
     */
    SnowflakeIdInfo parseSnowflakeId(long snowflakeId);
}
