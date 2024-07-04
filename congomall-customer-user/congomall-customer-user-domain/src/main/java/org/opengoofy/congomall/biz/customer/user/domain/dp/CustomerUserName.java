

package org.opengoofy.congomall.biz.customer.user.domain.dp;

import cn.hutool.core.util.StrUtil;
import org.opengoofy.congomall.springboot.starter.convention.exception.ClientException;
import lombok.Data;

/**
 * C 端用户名称
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class CustomerUserName {
    
    /**
     * 用户名
     */
    private final String username;
    
    /**
     * 用户名最少长度
     */
    private final static int MIN_USERNAME_LENGTH = 2;
    
    public CustomerUserName(String username) {
        username = StrUtil.trim(username);
        if (StrUtil.isBlank(username)) {
            throw new ClientException("用户名不允许为空");
        } else if (StrUtil.length(username) < MIN_USERNAME_LENGTH) {
            throw new ClientException("用户名长度最少2位");
        }
        this.username = username;
    }
}
