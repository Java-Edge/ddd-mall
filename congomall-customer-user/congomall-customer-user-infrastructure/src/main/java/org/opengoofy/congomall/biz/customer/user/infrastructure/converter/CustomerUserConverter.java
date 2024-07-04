

package org.opengoofy.congomall.biz.customer.user.infrastructure.converter;

import org.opengoofy.congomall.biz.customer.user.domain.aggregate.CustomerUser;
import org.opengoofy.congomall.biz.customer.user.infrastructure.dao.entity.CustomerUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * C 端用户 Entity 转换 DO
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Mapper(componentModel = "spring")
public interface CustomerUserConverter {
    
    /**
     * C 端用户 Entity 转换 DO
     *
     * @param customerUser
     * @return
     */
    @Mappings({
            @Mapping(source = "customerUser.username", target = "name"),
            @Mapping(source = "customerUser.phone", target = "phone"),
            @Mapping(source = "customerUser.password.password", target = "password"),
            @Mapping(source = "customerUser.accountNumber", target = "accountNumber")
    })
    CustomerUserDO customerUserToDO(CustomerUser customerUser);
    
    /**
     * C 端用户 DO 转换 Entity
     *
     * @param customerUserDO
     * @return
     */
    @Mappings({
            @Mapping(source = "id", target = "customerUserId"),
            @Mapping(source = "name", target = "username.username"),
            @Mapping(source = "mail", target = "mail.mail"),
            @Mapping(source = "phone", target = "phone.phone"),
            @Mapping(source = "password", target = "password.password"),
            @Mapping(source = "accountNumber", target = "accountNumber.accountNumber")
    })
    CustomerUser doToCustomerUser(CustomerUserDO customerUserDO);
}
