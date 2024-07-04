

package org.opengoofy.congomall.flow.monitor.plugin.hook;

import org.opengoofy.congomall.flow.monitor.core.conf.Config;
import org.opengoofy.congomall.flow.monitor.plugin.toolkit.Environments;

/**
 * 初始化 `spring.profiles.active` 属性值
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class InitializingProfilesActiveHook implements InitializingHook {
    
    @Override
    public void afterAgentPremain() throws Exception {
        Config.Environment.SPRING_PROFILES_ACTIVE = Environments.getSpringProfilesActive();
    }
}
