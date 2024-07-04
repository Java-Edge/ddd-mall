

package org.opengoofy.congomall.biz.basicdata.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 行政区划查询
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class RegionInfoListQuery {
    
    @ApiModelProperty("行政区划编号")
    private String code;
    
    @ApiModelProperty("行政区划名称")
    private String name;
    
    @ApiModelProperty("上级行政区划")
    private String parent;
    
    @ApiModelProperty("层级")
    private Integer level;
}
