

package org.opengoofy.congomall.biz.bff.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.opengoofy.congomall.biz.bff.common.ResultT;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.OrderCreateAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ProductCartAddAdapterReqDTO;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.ReceiveAddressSaveAdapterReqDTO;

/**
 * 自定义流控策略
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class CustomBlockHandler {
    
    public static ResultT<Boolean> addCardBlockHandlerMethod(ProductCartAddAdapterReqDTO requestParam, BlockException exception) {
        return new ResultT().setCode(500).setMessage("当前访问网站人数过多，请稍后再试...");
    }
    
    public static ResultT<Boolean> createOrderBlockHandlerMethod(OrderCreateAdapterReqDTO requestParam, BlockException exception) {
        return new ResultT().setCode(500).setMessage("当前访问网站人数过多，请稍后再试...");
    }
    
    public static ResultT<Boolean> addAddressBlockHandlerMethod(ReceiveAddressSaveAdapterReqDTO requestParam, BlockException exception) {
        return new ResultT().setCode(500).setMessage("当前访问网站人数过多，请稍后再试...");
    }
}
