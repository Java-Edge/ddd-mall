

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.dto.req.NavigationReqDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.NavigationAdapterRespDTO;

import java.util.List;

/**
 * 导航栏接口
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface NavigationService {
    
    /**
     * 查询所有导航栏数据
     *
     * @return 全部导航栏数据
     */
    List<NavigationAdapterRespDTO> listAllNavigation();
    
    /**
     * 新增导航栏数据
     *
     * @param requestParam 新增入参
     */
    void saveNavigation(NavigationReqDTO requestParam);
    
    /**
     * 修改导航栏数据
     *
     * @param requestParam 修改入参
     */
    void updateNavigation(NavigationReqDTO requestParam);
    
    /**
     * 删除导航栏数据
     *
     * @param id 导航栏数据 ID
     */
    void deleteNavigation(Integer id);
}
