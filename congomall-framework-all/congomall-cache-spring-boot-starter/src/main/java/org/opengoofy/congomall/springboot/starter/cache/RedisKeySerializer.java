

package org.opengoofy.congomall.springboot.starter.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * Redis Key 序列化
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RequiredArgsConstructor
public class RedisKeySerializer implements InitializingBean, RedisSerializer<String> {
    
    private final String keyPrefix;
    
    private final String charsetName;
    
    private Charset charset;
    
    @Override
    public byte[] serialize(String key) throws SerializationException {
        String builderKey = keyPrefix + key;
        return builderKey.getBytes();
    }
    
    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        return new String(bytes, charset);
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        charset = Charset.forName(charsetName);
    }
}
