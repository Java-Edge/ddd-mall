

package org.opengoofy.congomall.biz.message.domain.common;

import cn.hutool.core.collection.ListUtil;

import java.util.List;

/**
 * 消息常量类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class MessageConstants {
    
    /**
     * 短信发送渠道集合
     */
    public static final List<Integer> SMS_MESSAGE_CHANNELS = ListUtil.of(
            MessageTypeEnum.SMS_VERIFICATION_MESSAGE.getType(),
            MessageTypeEnum.SMS_INFORM_MESSAGE.getType(),
            MessageTypeEnum.SMS_MARKETING_MESSAGE.getType());
    
    /**
     * 短信消息模板
     */
    public static final String SMS_MESSAGE_KEY = "SMS_MESSAGE_";
}
