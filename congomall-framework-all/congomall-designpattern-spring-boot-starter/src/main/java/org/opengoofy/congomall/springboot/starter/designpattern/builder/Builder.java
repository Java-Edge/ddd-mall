package org.opengoofy.congomall.springboot.starter.designpattern.builder;

import java.io.Serializable;

/**
 * Builder 模式抽象接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface Builder<T> extends Serializable {
    
    /**
     * 构建方法
     *
     * @return 构建后的对象
     */
    T build();
}
