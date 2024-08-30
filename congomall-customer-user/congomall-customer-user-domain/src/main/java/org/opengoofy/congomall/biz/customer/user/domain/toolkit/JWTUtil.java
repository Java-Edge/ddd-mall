package org.opengoofy.congomall.biz.customer.user.domain.toolkit;

import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Maps;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class JWTUtil {
    
    public static final String TOKEN_HEADER = "Authorization";
    
    public static final String TOKEN_PREFIX = "Bearer ";
    
    private static final long EXPIRATION = 86400L;
    
    public static final String ISS = "congo-mall";
    
    public static final String SECRET = "SecretKey039245678901232039487623456783092349288901402967890140939827";
    
    /**
     * 生成 C 端用户 Token
     *
     * @param customerUser
     * @return
     */
    public static String generateAccessToken(CustomerUser customerUser) {
        Map<String, Object> customerUserMap = Maps.newHashMap();
        customerUserMap.put("username", customerUser.getUsername());
        customerUserMap.put("accountNumber", customerUser.getAccountNumber());
        customerUserMap.put("customerUserId", customerUser.getCustomerUserId());
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuedAt(new Date())
                .setIssuer(ISS)
                .setSubject(JSON.toJSONString(customerUserMap))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
    }
}