

package org.opengoofy.congomall.biz.bff.remote.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品品牌
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class ProductBrandRespDTO {
    
    @ApiModelProperty("id")
    private Long id;
    
    @ApiModelProperty("品牌名称")
    private String name;
    
    @ApiModelProperty("品牌介绍")
    private String desc;
    
    @ApiModelProperty("品牌图")
    private String pic;
    
    @ApiModelProperty("排序")
    private Integer sort;
}
