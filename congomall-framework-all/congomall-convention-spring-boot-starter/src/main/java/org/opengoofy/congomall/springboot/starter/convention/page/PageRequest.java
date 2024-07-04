package org.opengoofy.congomall.springboot.starter.convention.page;

import lombok.Data;

/**
 * 分页请求对象
 *
 * <p> {@link PageRequest}、{@link PageResponse}
 * 可理解为防腐层的一种实现，不论底层 ORM 框架，对外分页参数属性不变
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class PageRequest {
    
    /**
     * 当前页
     */
    private Long current;
    
    /**
     * 每页显示条数
     */
    private Long size;
}