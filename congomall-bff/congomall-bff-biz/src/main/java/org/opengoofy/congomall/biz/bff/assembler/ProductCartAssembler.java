

package org.opengoofy.congomall.biz.bff.assembler;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.ProductCartAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.remote.resp.CartItemRespDTO;

import java.util.List;

/**
 * 用户购物车返回对象映射转换
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper(componentModel = "spring")
public interface ProductCartAssembler {
    
    /**
     * 转换用户购物车返回实体
     */
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "limitNum", target = "limitNum", defaultValue = "100"),
            @Mapping(source = "selectFlag", target = "checked"),
            @Mapping(source = "productPic", target = "productImg"),
            @Mapping(source = "productName", target = "productName"),
            @Mapping(source = "productQuantity", target = "productNum"),
            @Mapping(source = "productPrice", target = "salePrice")
    })
    ProductCartAdapterRespDTO covert(CartItemRespDTO requestParam);
    
    /**
     * 批量转换用户购物车返回实体
     */
    @InheritInverseConfiguration(name = "convert")
    List<ProductCartAdapterRespDTO> covert(List<CartItemRespDTO> requestParam);
}
