

package org.opengoofy.congomall.biz.basicdata.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.basicdata.domain.aggregate.RegionInfo;
import org.opengoofy.congomall.biz.basicdata.domain.repository.RegionInfoRepository;
import org.opengoofy.congomall.biz.basicdata.infrastructure.dao.mapper.RegionInfoMapper;
import org.opengoofy.congomall.biz.basicdata.infrastructure.dao.entity.RegionInfoDO;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 行政区划仓储层实现
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Repository
@RequiredArgsConstructor
public class RegionInfoRepositoryImpl implements RegionInfoRepository {
    
    private final RegionInfoMapper regionInfoMapper;
    
    @Override
    public List<RegionInfo> listAllRegionInfo() {
        LambdaQueryWrapper<RegionInfoDO> queryWrapper = Wrappers.lambdaQuery(RegionInfoDO.class).select(
                RegionInfoDO::getId,
                RegionInfoDO::getCode,
                RegionInfoDO::getName,
                RegionInfoDO::getParent,
                RegionInfoDO::getLevel,
                RegionInfoDO::getSort);
        List<RegionInfoDO> regionInfoDOList = regionInfoMapper.selectList(queryWrapper);
        return BeanUtil.convert(regionInfoDOList, RegionInfo.class);
    }
    
    @Override
    public List<RegionInfo> listRegionInfoByLevel(Integer level) {
        LambdaQueryWrapper<RegionInfoDO> queryWrapper = Wrappers.lambdaQuery(RegionInfoDO.class)
                .eq(RegionInfoDO::getLevel, level)
                .select(
                        RegionInfoDO::getId,
                        RegionInfoDO::getCode,
                        RegionInfoDO::getName,
                        RegionInfoDO::getParent,
                        RegionInfoDO::getLevel,
                        RegionInfoDO::getSort);
        List<RegionInfoDO> regionInfoDOList = regionInfoMapper.selectList(queryWrapper);
        return BeanUtil.convert(regionInfoDOList, RegionInfo.class);
    }
    
    @Override
    public List<RegionInfo> listRegionInfoByCode(String code) {
        LambdaQueryWrapper<RegionInfoDO> queryWrapper = Wrappers.lambdaQuery(RegionInfoDO.class)
                .eq(RegionInfoDO::getCode, code)
                .select(
                        RegionInfoDO::getId,
                        RegionInfoDO::getCode,
                        RegionInfoDO::getName,
                        RegionInfoDO::getParent,
                        RegionInfoDO::getLevel,
                        RegionInfoDO::getSort);
        List<RegionInfoDO> regionInfoDOList = regionInfoMapper.selectList(queryWrapper);
        return BeanUtil.convert(regionInfoDOList, RegionInfo.class);
    }
    
    @Override
    public List<RegionInfo> listRegionInfoByParent(String parent) {
        LambdaQueryWrapper<RegionInfoDO> queryWrapper = Wrappers.lambdaQuery(RegionInfoDO.class)
                .eq(RegionInfoDO::getParent, parent)
                .select(
                        RegionInfoDO::getId,
                        RegionInfoDO::getCode,
                        RegionInfoDO::getName,
                        RegionInfoDO::getParent,
                        RegionInfoDO::getLevel,
                        RegionInfoDO::getSort);
        List<RegionInfoDO> regionInfoDOList = regionInfoMapper.selectList(queryWrapper);
        return BeanUtil.convert(regionInfoDOList, RegionInfo.class);
    }
}
