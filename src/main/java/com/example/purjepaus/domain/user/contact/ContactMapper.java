package com.example.purjepaus.domain.user.contact;

import com.example.purjepaus.business.user.dto.ContactInfo;
import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.business.user.dto.UserInfoUpdate;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {


    @Mapping(source = "contactFirstName", target = "firstName")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactEmail", target = "email")
    @Mapping(source = "contactAddress", target = "address")
    @Mapping(source = "contactTelephone", target = "telephone")
    @Mapping(source = "contactIsCaptain", target = "isCaptain")
    Contact toContact(UserInfo userInfo);

    ContactInfo toContactInfo(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "isCaptain")
    @Mapping(source = "contactFirstName", target = "firstName")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactEmail", target = "email")
    @Mapping(source = "contactAddress", target = "address")
    @Mapping(source = "contactTelephone", target = "telephone")
    Contact partialUpdate(UserInfoUpdate userInfoUpdate, @MappingTarget Contact contact);


}