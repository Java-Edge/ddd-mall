package org.opengoofy.congomall.biz.customer.user.application.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserRegisterRespDTO;
import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;

/**
 * C 端用户 Entity 转换 DTO
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper(componentModel = "spring")
public interface CustomerUserToDTOAssembler {
    
    /**
     * C 端用户 Entity 转换用户注册返回 DTO
     */
    @Mappings({
            @Mapping(source = "customerUser.username", target = "name"),
            @Mapping(source = "customerUser.phone", target = "phone"),
            @Mapping(source = "customerUser.accountNumber", target = "accountNumber")
    })
    UserRegisterRespDTO customerUserToUserRegisterRespDTO(CustomerUser customerUser);
    
    /**
     * C 端用户 Entity 转换用户登录返回 DTO
     */
    @Mappings({
            @Mapping(source = "customerUser.customerUserId", target = "customerUserId"),
            @Mapping(source = "customerUser.username", target = "username"),
            @Mapping(source = "customerUser.accountNumber", target = "accountNumber")
    })
    UserLoginRespDTO customerUserToUserLoginRespDTO(CustomerUser customerUser);
}