

package org.opengoofy.congomall.springboot.starter.distributedid.core.snowflake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WorkId 包装器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkIdWrapper {
    
    /**
     * 工作ID
     */
    private Long workId;
    
    /**
     * 数据中心ID
     */
    private Long dataCenterId;
}
