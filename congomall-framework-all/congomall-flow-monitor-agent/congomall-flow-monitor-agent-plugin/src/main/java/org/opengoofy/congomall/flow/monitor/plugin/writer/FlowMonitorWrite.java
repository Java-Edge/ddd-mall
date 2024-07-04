

package org.opengoofy.congomall.flow.monitor.plugin.writer;

import com.wujiuye.flow.FlowType;
import com.wujiuye.flow.Flower;
import org.opengoofy.congomall.flow.monitor.plugin.common.SID;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorRuntimeContext;
import org.opengoofy.congomall.flow.monitor.plugin.toolkit.Environments;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 微服务流量监控写入器
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class FlowMonitorWrite {
    
    private final static ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    private final static AtomicBoolean INIT_FLAG = new AtomicBoolean(Boolean.FALSE);
    
    /**
     * 初始化定时写入流量监控数据
     */
    public static void initScheduleWriteData() {
        if (!INIT_FLAG.get()) {
            synchronized (FlowMonitorWrite.class) {
                SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(() -> FlowMonitorRuntimeContext.STORAGE.forEach((interfaceKey, val) -> {
                    // System.out.println("------------------------------------------");
                    // System.out.println(String.format("------------ 目标接口: %s", interfaceKey));
                    val.forEach((sourceApplication, hosts) -> hosts.forEach((host, param) -> {
                        Flower flower = param.getFlowHelper().getFlow(FlowType.Minute);
                        FlowMonitorRunState runState = FlowMonitorRunState.builder()
                                .targetApplication(Environments.getApplicationName())
                                .targetIpPort(SID.getIpAddressAndPort())
                                .targetResource(interfaceKey)
                                .sourceApplication(sourceApplication)
                                .sourceIpPort(host)
                                .sourceResource(param.getSourceResource())
                                .total(flower.total())
                                .totalSuccess(flower.totalSuccess())
                                .totalException(flower.totalException())
                                .avgRt(flower.avgRt())
                                .maxRt(flower.maxRt())
                                .minRt(flower.minRt())
                                .successAvg(flower.successAvg())
                                .exceptionAvg(flower.exceptionAvg())
                                .type(param.getType())
                                .build();
                        MicrometerStorageExecutor.execute(runState);
                        // System.out.println(String.format("------------ 来源应用: %s", sourceApplication));
                        // System.out.println(String.format("------------ 来源接口: %s", param.getSourceResource()));
                        // System.out.println(String.format("------------ 来源 Host: %s", host));
                        // System.out.println("------------------------------------------");
                        // System.out.println("总请求数: " + flower.total());
                        // System.out.println("成功请求数: " + flower.totalSuccess());
                        // System.out.println("异常请求数: " + flower.totalException());
                        // System.out.println("平均请求耗时: " + flower.avgRt());
                        // System.out.println("最大请求耗时: " + flower.maxRt());
                        // System.out.println("最小请求耗时: " + flower.minRt());
                        // System.out.println("平均请求成功数: " + flower.successAvg());
                        // System.out.println("平均请求异常数: " + flower.exceptionAvg());
                    }));
                }), 0, 60, TimeUnit.SECONDS);
                INIT_FLAG.set(Boolean.TRUE);
            }
        }
    }
}
