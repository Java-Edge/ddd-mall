

package org.opengoofy.congomall.biz.basicdata.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.basicdata.application.resp.RegionInfoRespDTO;
import org.opengoofy.congomall.biz.basicdata.application.service.RegionInfoService;
import org.opengoofy.congomall.biz.basicdata.domain.aggregate.RegionInfo;
import org.opengoofy.congomall.biz.basicdata.domain.repository.RegionInfoRepository;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行政区划接口层实现
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@RequiredArgsConstructor
public class RegionInfoServiceImpl implements RegionInfoService {
    
    private final RegionInfoRepository regionInfoRepository;
    
    @Override
    public List<RegionInfoRespDTO> listAllRegionInfo() {
        List<RegionInfo> regionInfoList = regionInfoRepository.listAllRegionInfo();
        return BeanUtil.convert(regionInfoList, RegionInfoRespDTO.class);
    }
    
    @Override
    public List<RegionInfoRespDTO> listRegionInfoByLevel(Integer level) {
        List<RegionInfo> regionInfoList = regionInfoRepository.listRegionInfoByLevel(level);
        return BeanUtil.convert(regionInfoList, RegionInfoRespDTO.class);
    }
    
    @Override
    public List<RegionInfoRespDTO> listRegionInfoByCode(String code) {
        List<RegionInfo> regionInfoList = regionInfoRepository.listRegionInfoByCode(code);
        return BeanUtil.convert(regionInfoList, RegionInfoRespDTO.class);
    }
    
    @Override
    public List<RegionInfoRespDTO> listRegionInfoByParent(String parent) {
        List<RegionInfo> regionInfoList = regionInfoRepository.listRegionInfoByParent(parent);
        return BeanUtil.convert(regionInfoList, RegionInfoRespDTO.class);
    }
}
