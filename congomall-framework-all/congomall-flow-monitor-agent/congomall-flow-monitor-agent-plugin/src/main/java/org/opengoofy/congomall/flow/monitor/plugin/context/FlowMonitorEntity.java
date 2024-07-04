

package org.opengoofy.congomall.flow.monitor.plugin.context;

import com.wujiuye.flow.FlowHelper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 来源客户端参数
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowMonitorEntity {
    
    /**
     * 流量监控类型
     */
    private String type;
    
    /**
     * 目标应用
     */
    private String targetApplication;
    
    /**
     * 目标请求资源
     */
    private String targetResource;
    
    /**
     * 目标 IP Port
     */
    private String targetIpPort;
    
    /**
     * 来源应用名
     */
    private String sourceApplication;
    
    /**
     * 来源请求资源
     */
    private String sourceResource;
    
    /**
     * 来源 IP Port
     */
    private String sourceIpPort;
    
    /**
     * 请求方法
     */
    private String requestMethod;
    
    /**
     * 流量统计
     */
    private FlowHelper flowHelper;
}
