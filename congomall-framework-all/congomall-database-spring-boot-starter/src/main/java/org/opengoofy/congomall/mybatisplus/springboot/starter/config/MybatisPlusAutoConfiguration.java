package org.opengoofy.congomall.mybatisplus.springboot.starter.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.opengoofy.congomall.mybatisplus.springboot.starter.CustomIdGenerator;
import org.opengoofy.congomall.mybatisplus.springboot.starter.MyMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * MybatisPlus 配置文件
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class MybatisPlusAutoConfiguration {
    
    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
    
    /**
     * 元数据填充
     */
    @Bean
    public MyMetaObjectHandler myMetaObjectHandler() {
        return new MyMetaObjectHandler();
    }
    
    /**
     * 自定义雪花算法 ID 生成器
     */
    @Bean
    @Primary
    public IdentifierGenerator idGenerator() {
        return new CustomIdGenerator();
    }
}