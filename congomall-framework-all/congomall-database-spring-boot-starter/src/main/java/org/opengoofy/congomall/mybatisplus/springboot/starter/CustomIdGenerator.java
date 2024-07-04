package org.opengoofy.congomall.mybatisplus.springboot.starter;

import org.opengoofy.congomall.springboot.starter.distributedid.SnowflakeIdUtil;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * 自定义雪花算法生成器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class CustomIdGenerator implements IdentifierGenerator {
    
    @Override
    public Number nextId(Object entity) {
        return SnowflakeIdUtil.nextId();
    }
}