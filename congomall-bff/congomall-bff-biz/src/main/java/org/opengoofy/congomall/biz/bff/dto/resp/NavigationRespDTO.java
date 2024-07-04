

package org.opengoofy.congomall.biz.bff.dto.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 导航栏返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class NavigationRespDTO {
    
    @ApiModelProperty("id")
    private Integer id;
    
    @ApiModelProperty("面板id")
    private Integer panelId;
    
    @ApiModelProperty("名称")
    private String name;
    
    @ApiModelProperty("跳转地址")
    private String url;
    
    @ApiModelProperty("排序")
    private Integer sort;
    
    @ApiModelProperty("类型")
    private Integer type;
}
