

package org.opengoofy.congomall.biz.basicdata.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

/**
 * 行政区划聚合根
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionInfo implements AggregateRoot {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 行政区划编号
     */
    private String code;
    
    /**
     * 行政区划名称
     */
    private String name;
    
    /**
     * 上级行政区划
     */
    private String parent;
    
    /**
     * 排序
     */
    private Integer sort;
    
    /**
     * 层级
     */
    private Integer level;
}
