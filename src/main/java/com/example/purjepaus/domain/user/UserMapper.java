package com.example.purjepaus.domain.user;

import com.example.purjepaus.business.Status;
import com.example.purjepaus.business.login.dto.LoginResponse;
import com.example.purjepaus.business.user.dto.CaptainInfo;
import com.example.purjepaus.business.user.dto.NewUser;
import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.business.user.dto.UserPassword;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    User toUser(NewUser newUser);

    @Mapping(source = "contact.firstName", target = "contactFirstName")
    @Mapping(source = "contact.lastName", target = "contactLastName")
    @Mapping(source = "contact.email", target = "contactEmail")
    @Mapping(source = "contact.telephone", target = "contactTelephone")
    @Mapping(source = "contact.address", target = "contactAddress")
    UserInfo toUserInfo(User user);


    UserPassword toUserPassword(String password);

    @Mapping(source = "contact.id", target = "contactId")
    @Mapping(source = "contact.firstName", target = "contactFirstName")
    @Mapping(source = "contact.lastName", target = "contactLastName")
    CaptainInfo toCaptainInfo(User user);

    List<CaptainInfo> toCaptainsInfo(List<User> users);

}