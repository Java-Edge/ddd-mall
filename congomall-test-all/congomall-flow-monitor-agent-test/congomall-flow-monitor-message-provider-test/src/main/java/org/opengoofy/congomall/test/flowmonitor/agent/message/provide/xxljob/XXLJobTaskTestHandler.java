

package org.opengoofy.congomall.test.flowmonitor.agent.message.provide.xxljob;

import com.alibaba.nacos.common.utils.ThreadUtils;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * XXL-Job 任务测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@Component
public class XXLJobTaskTestHandler extends IJobHandler {
    
    @XxlJob(value = "demoJobHandler")
    @Override
    public void execute() throws Exception {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        log.info("执行任务... sleep time: {}", nextInt);
        if (nextInt % 2 == 0) {
            throw new RuntimeException();
        }
    }
}
