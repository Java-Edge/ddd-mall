package org.opengoofy.congomall.biz.customer.user.application.service.handler.verify;

import cn.hutool.core.util.RandomUtil;
import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.infrastructure.remote.MessageSendRemoteService;
import org.opengoofy.congomall.biz.customer.user.infrastructure.remote.dto.MailSendRemoteCommand;
import org.opengoofy.congomall.springboot.starter.cache.DistributedCache;
import org.opengoofy.congomall.springboot.starter.cache.toolkit.CacheUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * 抽象邮箱验证码发送
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public abstract class AbstractMailVerifySender {
    
    @Value("${customer.user.register.verify.sender}")
    private String sender;
    
    @Value("${customer.user.register.verify.template-id}")
    private String templateId;
    
    @Resource
    private MessageSendRemoteService messageSendRemoteService;
    
    @Resource
    private DistributedCache distributedCache;
    
    /**
     * 用户注册验证码超时时间
     */
    private static final long REGISTER_USER_VERIFY_CODE_TIMEOUT = 300000;
    
    /**
     * 获取缓存前置 Key
     *
     * @return
     */
    protected abstract String getCachePrefixKey();
    
    /**
     * 邮箱验证发送
     *
     * @param requestParam
     */
    public void mailVerifySend(UserVerifyCodeCommand requestParam) {
        String verifyCode = RandomUtil.randomNumbers(6);
        // 模板方法模式: 验证码放入缓存，并设置超时时间
        distributedCache.put(CacheUtil.buildKey(getCachePrefixKey(), requestParam.getReceiver()), verifyCode, REGISTER_USER_VERIFY_CODE_TIMEOUT);
        MailSendRemoteCommand remoteCommand = new MailSendRemoteCommand();
        remoteCommand.setTitle("刚果商城邮箱验证码提醒")
                .setReceiver(requestParam.getReceiver())
                .setSender(sender)
                .setTemplateId(templateId)
                .setParamList(Lists.newArrayList(verifyCode));
        messageSendRemoteService.mailMessageSend(remoteCommand);
    }
}
