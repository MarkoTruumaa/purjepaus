package com.example.purjepaus.domain.user;

import com.example.purjepaus.business.login.dto.LoginResponse;
import com.example.purjepaus.business.user.UserInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "contactIsCaptain", target = "contact.isCaptain")
    @Mapping(source = "contactAddress", target = "contact.address")
    @Mapping(source = "contactTelephone", target = "contact.telephone")
    @Mapping(source = "contactEmail", target = "contact.email")
    @Mapping(source = "contactLastName", target = "contact.lastName")
    @Mapping(source = "contactFirstName", target = "contact.firstName")
    User toUser(UserInfo UserInfo, @MappingTarget User user);

}