

package org.opengoofy.congomall.biz.bff.dto.resp.adapter;

import lombok.Data;

/**
 * 极验验证码适配返回对象
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class GeeTestAdapterRespDTO {
    
    private String challenge;
    
    private String gt;
    
    private String statusKey;
    
    private Integer success;
}
