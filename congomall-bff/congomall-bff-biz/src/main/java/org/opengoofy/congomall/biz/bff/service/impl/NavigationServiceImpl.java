

package org.opengoofy.congomall.biz.bff.service.impl;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.assembler.NavigationAssembler;
import org.opengoofy.congomall.biz.bff.dao.entity.NavigationDO;
import org.opengoofy.congomall.biz.bff.dao.mapper.NavigationMapper;
import org.opengoofy.congomall.biz.bff.dto.req.NavigationReqDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.NavigationRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.NavigationAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.service.NavigationService;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 导航栏接口实现
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@RequiredArgsConstructor
public class NavigationServiceImpl implements NavigationService {
    
    private final NavigationMapper navigationMapper;
    private final NavigationAssembler navigationAssembler;
    
    @Override
    @Cached(name = "navigation:", key = "'list-all-navigation'", expire = 24, timeUnit = TimeUnit.HOURS)
    public List<NavigationAdapterRespDTO> listAllNavigation() {
        List<NavigationDO> navigationDOList = navigationMapper.selectList(Wrappers.emptyWrapper());
        List<NavigationRespDTO> navigationRespDTOList = BeanUtil.convert(navigationDOList, NavigationRespDTO.class);
        return navigationAssembler.convert(navigationRespDTOList);
    }
    
    @Override
    public void saveNavigation(NavigationReqDTO requestParam) {
        navigationMapper.insert(BeanUtil.convert(requestParam, NavigationDO.class));
    }
    
    @Override
    public void updateNavigation(NavigationReqDTO requestParam) {
        navigationMapper.updateById(BeanUtil.convert(requestParam, NavigationDO.class));
    }
    
    @Override
    public void deleteNavigation(Integer id) {
        navigationMapper.deleteById(id);
    }
}
