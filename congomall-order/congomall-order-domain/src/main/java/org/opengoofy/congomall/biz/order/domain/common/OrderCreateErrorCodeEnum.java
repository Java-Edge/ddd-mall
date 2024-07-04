

package org.opengoofy.congomall.biz.order.domain.common;

import lombok.AllArgsConstructor;
import org.opengoofy.congomall.springboot.starter.convention.errorcode.IErrorCode;

/**
 * 订单创建错误码枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@AllArgsConstructor
public enum OrderCreateErrorCodeEnum implements IErrorCode {
    
    CUSTOMER_USER_ID_NOTNULL("A006001", "用户ID不能为空"),
    
    TOTAL_AMOUNT_NOTNULL("A006002", "订单总金额不能为空"),
    
    PAY_AMOUNT_NOTNULL("A006003", "支付金额不能为空"),
    
    FREIGHT_AMOUNT_NOTNULL("A006004", "运费金额不能为空"),
    
    SOURCE_NOTNULL("A006005", "订单来源不能为空"),
    
    // xxx 这里应该把所有订单入参创建对应错误码，因为重复工作量所以暂时验证上述这些
    
    TOTAL_AMOUNT_ERROR("A006051", "订单金额错误，最低不能小于或等于0"),
    
    PAY_AMOUNT_ERROR("A006052", "支付金额错误，最低不能小于或等于0"),
    
    FREIGHT_AMOUNT_ERROR("A006053", "运费金额错误，最低不能小于0"),
    
    AMOUNT_VERIFICATION_ERROR("A006054", "订单金额验证失败"),
    
    PRODUCT_CART_ISNULL_ERROR("A006100", "获取购物车商品信息失败"),
    
    PRODUCT_STOCK_VERIFY_ERROR("A006101", "商品库存验证失败");
    
    /**
     * 错误码
     */
    private final String code;
    
    /**
     * 错误提示消息
     */
    private final String message;
    
    @Override
    public String code() {
        return code;
    }
    
    @Override
    public String message() {
        return message;
    }
}
