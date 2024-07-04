

package org.opengoofy.congomall.biz.bff.common;

import lombok.Data;

import java.util.List;

/**
 * 分页适配
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class PageAdapter<T> {
    
    private Integer recordsFiltered;
    
    private Long recordsTotal;
    
    private Integer draw;
    
    private Boolean success;
    
    private List<T> data;
    
    private Object error;
}
