package com.example.purjepaus.domain.user;

import com.example.purjepaus.business.Status;
import com.example.purjepaus.business.login.dto.LoginResponse;
import com.example.purjepaus.business.user.dto.UserInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    User toUser(UserInfo UserInfo);

}