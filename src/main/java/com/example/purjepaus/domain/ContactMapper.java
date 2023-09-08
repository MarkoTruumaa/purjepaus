package com.example.purjepaus.domain;

import com.example.purjepaus.business.user.ContactInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {


    @Mapping(source = "id", target = "contactId")
    ContactInfo toContactInfo(Contact contact);

}