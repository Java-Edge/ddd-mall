

package org.opengoofy.congomall.biz.message.infrastructure.algorithm;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 计算分片表地址
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
public class ShardModel {
    
    public static final String SEND_MSG_SHARD_TABLE = "%s_%d_m%d";
    
    public static String quarterlyModel(String table, Date date) {
        int year = DateUtil.year(date);
        int quarter = DateUtil.month(date) + 1;
        return String.format(SEND_MSG_SHARD_TABLE, table, year, quarter);
    }
    
    public static List<String> calculateRange(String tableName, Date start, Date end) {
        int year = DateUtil.year(start);
        List<String> result = Lists.newLinkedList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        while (calendar.getTime().before(end)) {
            int month = calendar.get(Calendar.MONTH);
            result.add(String.format(SEND_MSG_SHARD_TABLE, tableName, year, month + 1));
            if (month == 11) {
                year += 1;
            }
            calendar.add(Calendar.MONTH, 1);
        }
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        if (calendar.get(Calendar.MONTH) == endCalendar.get(Calendar.MONTH)) {
            int month = calendar.get(Calendar.MONTH);
            result.add(String.format(tableName + "_%d_m%d", year, month + 1));
        }
        return result;
    }
    
    public static void main(String[] args) {
        // 测试精确时间查询
        DateTime fakeDate = DateUtil.parseDate(String.format("%s-%s-%s 00:00:00", 2020, 03, 01));
        System.out.println(quarterlyModel("send_record", fakeDate));
        // 测试范围时间查询
        DateTime fakeDate2 = DateUtil.parseDate(String.format("%s-%s-%s 00:00:00", 2021, 05, 01));
        System.out.println(calculateRange("send_record", fakeDate, fakeDate2));
    }
}
