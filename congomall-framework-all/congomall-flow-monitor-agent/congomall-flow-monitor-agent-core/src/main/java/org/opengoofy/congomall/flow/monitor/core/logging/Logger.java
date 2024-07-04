

package org.opengoofy.congomall.flow.monitor.core.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    
    public static void info(String format, Object... args) {
        String msg = String.format(format, args);
        Logger.info(msg);
    }
    
    public static void info(String msg) {
        logMessage(msg, "INFO");
    }
    
    public static void error(String format, Object... args) {
        String msg = String.format(format, args);
        Logger.error(msg);
    }
    
    public static void error(String msg) {
        logMessage(msg, "ERROR");
    }
    
    public static void error(String msg, Throwable throwable) {
        logMessage(msg, "ERROR");
    }
    
    private static void logMessage(String msg, String type) {
        String threadName = Thread.currentThread().getName();
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss-SSS");
        String strTime = sdFormatter.format(nowTime);
        String info = String.format("[%s][%s][%s] %s", strTime, threadName, type, msg);
        System.out.println(info);
    }
}
