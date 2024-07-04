

package org.opengoofy.congomall.flow.monitor.plugin.context;

import lombok.Data;

/**
 * 微服务流量监控基础实体信息
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
public class FlowMonitorBaseEntity {
    
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
}
