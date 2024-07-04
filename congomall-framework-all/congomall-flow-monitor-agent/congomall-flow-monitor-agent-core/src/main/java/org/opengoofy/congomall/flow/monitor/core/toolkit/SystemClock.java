

package org.opengoofy.congomall.flow.monitor.core.toolkit;

import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 系统时钟<br>
 * 高并发场景下 System.currentTimeMillis() 的性能问题的优化
 *
 * @author https://github.com/yu120/neural
 * @github <a href="https://github.com/opengoofy" />
 * @公众号  JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class SystemClock {
    
    /**
     * 时钟更新间隔，单位毫秒
     */
    private final long period;
    
    /**
     * 现在时刻的毫秒数
     */
    private volatile long now;
    
    /**
     * 构造
     *
     * @param period 时钟更新间隔，单位毫秒
     */
    public SystemClock(long period) {
        this.period = period;
        this.now = System.currentTimeMillis();
        scheduleClockUpdating();
    }
    
    /**
     * 开启计时器线程
     */
    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "System Clock");
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleAtFixedRate(() -> now = System.currentTimeMillis(), period, period, TimeUnit.MILLISECONDS);
    }
    
    /**
     * @return 当前时间毫秒数
     */
    private long currentTimeMillis() {
        return now;
    }
    
    /**
     * 单例
     *
     * @author Looly
     */
    private static class InstanceHolder {
        
        public static final SystemClock INSTANCE = new SystemClock(1);
    }
    
    /**
     * @return 当前时间
     */
    public static long now() {
        return InstanceHolder.INSTANCE.currentTimeMillis();
    }
    
    /**
     * @return 当前时间字符串表现形式
     */
    public static String nowDate() {
        return new Timestamp(InstanceHolder.INSTANCE.currentTimeMillis()).toString();
    }
}
