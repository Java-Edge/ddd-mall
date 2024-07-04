

package org.opengoofy.congomall.biz.cart.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 购物车勾选状态
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@AllArgsConstructor
public enum SelectFlagEnum {
    
    /**
     * 购物车商品未选中状态
     */
    UNSELECTED(0),
    
    /**
     * 购物车商品选中状态
     */
    SELECTED(1);
    
    @Getter
    private final int code;
}
