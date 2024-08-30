package org.opengoofy.congomall.springboot.starter.idempotent.core;

import org.opengoofy.congomall.springboot.starter.base.ApplicationContextHolder;
import org.opengoofy.congomall.springboot.starter.idempotent.core.param.IdempotentParamService;
import org.opengoofy.congomall.springboot.starter.idempotent.core.spel.IdempotentSpELByMQExecuteHandler;
import org.opengoofy.congomall.springboot.starter.idempotent.core.spel.IdempotentSpELByRestAPIExecuteHandler;
import org.opengoofy.congomall.springboot.starter.idempotent.core.token.IdempotentTokenService;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentSceneEnum;
import org.opengoofy.congomall.springboot.starter.idempotent.enums.IdempotentTypeEnum;
/**
 * 幂等执行处理器工厂
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public final class IdempotentExecuteHandlerFactory {
    
    /**
     * 获取幂等执行处理器
     *
     * @param scene 指定幂等验证场景类型
     * @param type  指定幂等处理类型
     * @return 幂等执行处理器
     */
    public static IdempotentExecuteHandler getInstance(IdempotentSceneEnum scene, IdempotentTypeEnum type) {
        IdempotentExecuteHandler result = null;
        switch (scene) {
            case RESTAPI:
                switch (type) {
                    case PARAM:
                        result = ApplicationContextHolder.getBean(IdempotentParamService.class);
                        break;
                    case TOKEN:
                        result = ApplicationContextHolder.getBean(IdempotentTokenService.class);
                        break;
                    case SPEL:
                        result = ApplicationContextHolder.getBean(IdempotentSpELByRestAPIExecuteHandler.class);
                        break;
                    default:
                        break;
                }
                break;
            case MQ:
                result = ApplicationContextHolder.getBean(IdempotentSpELByMQExecuteHandler.class);
                break;
            default:
                break;
        }
        return result;
    }
}