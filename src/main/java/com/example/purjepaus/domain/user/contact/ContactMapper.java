package com.example.purjepaus.domain.user.contact;

import com.example.purjepaus.business.ContactInfo;
import com.example.purjepaus.business.user.UserInfo;
import com.example.purjepaus.domain.user.contact.Contact;
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


}