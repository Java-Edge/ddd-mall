

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 首页板块适配请求对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class HomePanelAdapterRespDTO {
    
    /**
     * ID
     */
    private Integer id;
    
    /**
     * 限制数量
     */
    private Integer limitNum;
    
    /**
     * 板块名称
     */
    private String name;
    
    /**
     * 位置
     */
    private Integer position;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 排序
     */
    private Integer sortOrder;
    
    /**
     * 状态
     */
    private Integer status;
    
    /**
     * 类型
     */
    private Integer type;
    
    /**
     * 创建时间
     */
    private Date created;
    
    /**
     * 修改时间
     */
    private Date updated;
    
    /**
     * 商品数组
     */
    private List<HomePanelContentAdapterRespDTO> panelContents;
}
