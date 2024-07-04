

package org.opengoofy.congomall.biz.bff.assembler;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.opengoofy.congomall.biz.bff.dto.resp.NavigationRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.NavigationAdapterRespDTO;

import java.util.List;

/**
 * 导航栏返回对象映射转换
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper(componentModel = "spring")
public interface NavigationAssembler {
    
    /**
     * 转换商城导航栏返回实体
     */
    @Mappings({
            @Mapping(source = "name", target = "picUrl"),
            @Mapping(source = "name", target = "productImageBig"),
            @Mapping(source = "url", target = "fullUrl"),
            @Mapping(source = "sort", target = "sortOrder"),
            @Mapping(source = "type", target = "type", defaultValue = "0"),
            @Mapping(source = "panelId", target = "panelId", defaultValue = "0")
    })
    NavigationAdapterRespDTO convert(NavigationRespDTO navigationRespDTO);
    
    /**
     * 批量转换商城导航栏返回实体
     */
    @InheritInverseConfiguration(name = "convert")
    List<NavigationAdapterRespDTO> convert(List<NavigationRespDTO> navigationRespDTOList);
}
