

package org.opengoofy.congomall.springboot.starter.idempotent.toolkit;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

/**
 * SpEL 表达式解析工具
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class SpELUtil {
    
    /**
     * 校验并返回实际使用的 spEL 表达式
     *
     * @param spEl spEL 表达式
     * @return 实际使用的 spEL 表达式
     */
    public static Object parseKey(String spEl, Method method, Object[] contextObj) {
        String spElFlag = "#";
        if (!spEl.contains(spElFlag)) {
            return spEl;
        }
        return parse(spEl, method, contextObj);
    }
    
    /**
     * 转换参数为字符串
     *
     * @param spEl       spEl 表达式
     * @param contextObj 上下文对象
     * @return 解析的字符串值
     */
    public static Object parse(String spEl, Method method, Object[] contextObj) {
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(spEl);
        String[] params = discoverer.getParameterNames(method);
        StandardEvaluationContext context = new StandardEvaluationContext();
        if (ArrayUtil.isNotEmpty(params)) {
            for (int len = 0; len < params.length; len++) {
                context.setVariable(params[len], contextObj[len]);
            }
        }
        return exp.getValue(context);
    }
}
