

package org.opengoofy.congomall.flow.monitor.plugin.hook;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 初始化钩子函数管理
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public enum InitializingHookManager {
    
    INSTANCE;
    
    private Map<String, InitializingHook> initializingHooks = Collections.emptyMap();
    
    public void boot() {
        initializingHooks = loadInitializingHooks();
        initializingHooks.values().forEach(each -> {
            try {
                each.afterAgentPremain();
            } catch (Exception ignored) {
            }
        });
    }
    
    public Map<String, InitializingHook> loadInitializingHooks() {
        Map<String, InitializingHook> allInitializingHooks = new LinkedHashMap<>();
        allInitializingHooks.put(InitializingProfilesActiveHook.class.getName(), new InitializingProfilesActiveHook());
        return allInitializingHooks;
    }
}
