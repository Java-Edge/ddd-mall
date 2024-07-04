

package org.opengoofy.congomall.biz.basicdata.domain.repository;

import org.opengoofy.congomall.biz.basicdata.domain.aggregate.RegionInfo;

import java.util.List;

/**
 * 行政区划仓储层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface RegionInfoRepository {
    
    /**
     * 查询行政区划数据
     *
     * @return 全部行政区划数据
     */
    List<RegionInfo> listAllRegionInfo();
    
    /**
     * 根据层级查询行政区划数据
     *
     * @param level 层级，比如省市区三级，eg：1、2、3
     * @return 行政区划数据
     */
    List<RegionInfo> listRegionInfoByLevel(Integer level);
    
    /**
     * 根据编码查询行政区划数据
     *
     * @param code 行政区划编码，比如北京：110000
     * @return 行政区划数据
     */
    List<RegionInfo> listRegionInfoByCode(String code);
    
    /**
     * 根据上级行政区划编码查询行政区划数据
     *
     * @param parent 上级行政区划编码，比如北京：110000
     * @return 行政区划数据
     */
    List<RegionInfo> listRegionInfoByParent(String parent);
}
