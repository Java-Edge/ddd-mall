

package org.opengoofy.congomall.biz.cart.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.opengoofy.congomall.biz.cart.infrastructure.dao.entity.CartItemDO;

/**
 * 商品购物车
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface CartItemMapper extends BaseMapper<CartItemDO> {
    
    /**
     * 统计用户购物车商品数量
     */
    Integer countUserCartItem(String customerUserId);
}
