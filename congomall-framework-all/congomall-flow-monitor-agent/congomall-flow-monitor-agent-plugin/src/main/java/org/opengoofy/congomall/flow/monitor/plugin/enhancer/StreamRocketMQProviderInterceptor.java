

package org.opengoofy.congomall.flow.monitor.plugin.enhancer;

import org.opengoofy.congomall.flow.monitor.core.toolkit.SystemClock;
import org.opengoofy.congomall.flow.monitor.plugin.common.FlowMonitorFrameTypeEnum;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorEntity;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorRuntimeContext;
import org.opengoofy.congomall.flow.monitor.plugin.enhancer.base.AbstractInstanceMethodsAroundInterceptor;
import org.opengoofy.congomall.flow.monitor.plugin.provider.FlowMonitorSourceParamProviderFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SpringCloud Stream RocketMQ 生产端切面拦截增强
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class StreamRocketMQProviderInterceptor extends AbstractInstanceMethodsAroundInterceptor {
    
    @Override
    protected void beforeMethodExecute(Object obj, Method method, Object[] allArguments, Class<?>[] argumentsTypes) throws Throwable {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Objects.equals("org.apache.rocketmq.client.impl.consumer.ConsumeMessageConcurrentlyService$ConsumeRequest", stackTrace[stackTrace.length - 6].getClassName())) {
            return;
        }
        FlowMonitorRuntimeContext.pushEnhancerType(FlowMonitorFrameTypeEnum.STREAM_ROCKETMQ_PROVIDER);
        StackTraceElement stackTraceElement = stackTrace[7];
        FlowMonitorEntity sourceParam = FlowMonitorSourceParamProviderFactory.createInstance(buildKey(stackTraceElement), FlowMonitorFrameTypeEnum.STREAM_ROCKETMQ_PROVIDER);
        loadResource(sourceParam);
        FlowMonitorRuntimeContext.setExecuteTime();
    }
    
    @Override
    public void afterMethodExecute(Object obj, Method method, Object[] allArguments, Class<?>[] argumentsTypes, Object result, Throwable ex) throws Throwable {
        FlowMonitorEntity sourceParam = FlowMonitorSourceParamProviderFactory.getInstance(FlowMonitorRuntimeContext.BUILD_KEY_THREADLOCAL.get(), FlowMonitorFrameTypeEnum.STREAM_ROCKETMQ_PROVIDER);
        FlowMonitorEntity flowMonitorEntity = FlowMonitorRuntimeContext.getHost(sourceParam.getTargetResource(), sourceParam.getSourceApplication(), sourceParam.getSourceIpPort());
        if (ex != null) {
            flowMonitorEntity.getFlowHelper().incrException();
        } else {
            flowMonitorEntity.getFlowHelper().incrSuccess(SystemClock.now() - FlowMonitorRuntimeContext.getExecuteTime());
        }
    }
    
    private static String buildKey(StackTraceElement stackTraceElement) {
        String sendClass = stackTraceElement.getFileName().substring(0, stackTraceElement.getFileName().length() - 5);
        String sendMethodName = stackTraceElement.getMethodName();
        if (sendMethodName.indexOf("$") != -1) {
            sendMethodName = sendMethodName.substring(0, sendMethodName.indexOf("$"));
        }
        String key = new StringBuilder("/Producer/").append(sendClass).append("/").append(sendMethodName).toString();
        FlowMonitorRuntimeContext.BUILD_KEY_THREADLOCAL.set(key);
        return key;
    }
    
    private static void loadResource(FlowMonitorEntity sourceParam) {
        Map<String, Map<String, FlowMonitorEntity>> applications = FlowMonitorRuntimeContext.getApplications(sourceParam.getTargetResource());
        if (applications == null) {
            Map<String, Map<String, FlowMonitorEntity>> sourceApplications = new ConcurrentHashMap<>();
            Map<String, FlowMonitorEntity> hosts = new ConcurrentHashMap<>();
            hosts.put(sourceParam.getSourceIpPort(), sourceParam);
            sourceApplications.put(sourceParam.getSourceApplication(), hosts);
            FlowMonitorRuntimeContext.putApplications(sourceParam.getTargetResource(), sourceApplications);
        }
    }
}
