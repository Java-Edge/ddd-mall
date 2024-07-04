

package org.opengoofy.congomall.flow.monitor.plugin.enhancer;

import org.opengoofy.congomall.flow.monitor.core.toolkit.SystemClock;
import org.opengoofy.congomall.flow.monitor.plugin.common.FlowMonitorFrameTypeEnum;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorEntity;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorRuntimeContext;
import org.opengoofy.congomall.flow.monitor.plugin.context.FlowMonitorVirtualUriLoader;
import org.opengoofy.congomall.flow.monitor.plugin.enhancer.base.AbstractInstanceMethodsAroundInterceptor;
import org.opengoofy.congomall.flow.monitor.plugin.provider.FlowMonitorSourceParamProviderFactory;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring MVC 增强
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class SpringMvcInterceptor extends AbstractInstanceMethodsAroundInterceptor {
    
    @Override
    public void beforeMethodExecute(Object obj, Method method, Object[] allArguments, Class<?>[] argumentsTypes) throws Throwable {
        HttpServletRequest httpServletRequest = ((ServletWebRequest) allArguments[0]).getRequest();
        if (FlowMonitorRuntimeContext.hasFilterPath(httpServletRequest.getRequestURI())) {
            return;
        }
        FlowMonitorRuntimeContext.pushEnhancerType(FlowMonitorFrameTypeEnum.SPRING_MVC);
        FlowMonitorVirtualUriLoader.loadProviderUris();
        SpringMvcInterceptor.loadResource(httpServletRequest);
        FlowMonitorRuntimeContext.setExecuteTime();
    }
    
    @Override
    public void afterMethodExecute(Object obj, Method method, Object[] allArguments, Class<?>[] argumentsTypes, Object result, Throwable ex) throws Throwable {
        FlowMonitorEntity sourceParam = FlowMonitorSourceParamProviderFactory.getInstance(((ServletWebRequest) allArguments[0]).getRequest());
        FlowMonitorEntity flowMonitorEntity = FlowMonitorRuntimeContext.getHost(sourceParam.getTargetResource(), sourceParam.getSourceApplication(), sourceParam.getSourceIpPort());
        if (ex != null) {
            flowMonitorEntity.getFlowHelper().incrException();
        } else {
            flowMonitorEntity.getFlowHelper().incrSuccess(SystemClock.now() - FlowMonitorRuntimeContext.getExecuteTime());
        }
    }
    
    private static void loadResource(HttpServletRequest httpServletRequest) {
        FlowMonitorEntity sourceParam = FlowMonitorSourceParamProviderFactory.createInstance(httpServletRequest);
        Map<String, Map<String, FlowMonitorEntity>> sourceApplications;
        if ((sourceApplications = FlowMonitorRuntimeContext.getApplications(sourceParam.getTargetResource())) == null) {
            sourceApplications = new ConcurrentHashMap<>();
            Map<String, FlowMonitorEntity> hosts = new ConcurrentHashMap<>();
            hosts.put(sourceParam.getSourceIpPort(), sourceParam);
            sourceApplications.put(sourceParam.getSourceApplication(), hosts);
            FlowMonitorRuntimeContext.putApplications(sourceParam.getTargetResource(), sourceApplications);
        } else if (FlowMonitorRuntimeContext.getHosts(sourceParam.getTargetResource(), sourceParam.getSourceApplication()) == null) {
            Map<String, FlowMonitorEntity> hosts = new ConcurrentHashMap<>();
            hosts.put(sourceParam.getSourceIpPort(), sourceParam);
            sourceApplications.put(sourceParam.getSourceApplication(), hosts);
            FlowMonitorRuntimeContext.putHosts(sourceParam.getTargetResource(), sourceParam.getSourceApplication(), hosts);
        } else if (FlowMonitorRuntimeContext.getHost(sourceParam.getTargetResource(), sourceParam.getSourceApplication(), sourceParam.getSourceIpPort()) == null) {
            FlowMonitorRuntimeContext.putHost(sourceParam.getTargetResource(), sourceParam.getSourceApplication(), sourceParam.getSourceIpPort(), sourceParam);
        }
    }
}
