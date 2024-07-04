

package org.opengoofy.congomall.biz.bff.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * 支付方式枚举
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@RequiredArgsConstructor
public enum PayTypeEnum {
    
    /**
     * 阿里支付宝
     */
    ALI_PAY(0, "AliPay");
    
    @Getter
    private final int code;
    
    @Getter
    private final String name;
    
    public static String getNameByCode(int code) {
        return Arrays.stream(PayTypeEnum.values())
                .filter(each -> Objects.equals(code, each.getCode()))
                .findFirst()
                .map(PayTypeEnum::getName)
                .orElse(null);
    }
}
