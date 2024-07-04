

package org.opengoofy.congomall.flow.monitor.plugin.writer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorBaseEntity;

import java.io.Serializable;

/**
 * 微服务流量监控运行数据
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class FlowMonitorRunState extends FlowMonitorBaseEntity implements Serializable {
    
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
     * 全部请求数
     */
    private Long total;
    
    /**
     * 全部成功数
     */
    private Long totalSuccess;
    
    /**
     * 全部异常数
     */
    private Long totalException;
    
    /**
     * 平均请求成功数
     */
    private Float successAvg;
    
    /**
     * 平均请求异常数
     */
    private Long exceptionAvg;
    
    /**
     * 平均请求耗时
     */
    private Long avgRt;
    
    /**
     * 最小请求耗时
     */
    private Long minRt;
    
    /**
     * 最大请求耗时
     */
    private Long maxRt;
}
