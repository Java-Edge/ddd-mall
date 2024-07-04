

package org.opengoofy.congomall.biz.bff.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.opengoofy.congomall.biz.bff.dto.req.adapter.UserLoginAdapterRepDTO;
import org.opengoofy.congomall.biz.bff.remote.req.UserLoginCommand;

/**
 * 用户注册对象映射转换
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper(componentModel = "spring")
public interface UserLoginAssembler {
    
    /**
     * 转换商城导航栏返回实体
     */
    @Mappings({
            @Mapping(source = "userName", target = "accountNumber"),
            @Mapping(source = "userPwd", target = "password"),
            @Mapping(source = "loginType", target = "loginType", defaultValue = "USER_LOGIN_ACCOUNT")
    })
    UserLoginCommand loginRequestConvert(UserLoginAdapterRepDTO userLoginAdapterRepDTO);
}
