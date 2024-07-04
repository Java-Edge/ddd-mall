

package org.opengoofy.congomall.test.flow.monitor.user.provider.xxljob;

import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * XXL-Job 任务测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
public class XXLJobTaskTestHandler2 extends IJobHandler {
    
    @XxlJob(value = "demoJobHandler2")
    @Override
    public void execute() throws Exception {
        log.info("执行任务...");
    }
}
