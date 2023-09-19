package com.example.purjepaus.domain.harbour.location;

import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import com.example.purjepaus.business.harbour.dto.UpdateHarbourAndExtras;
import com.example.purjepaus.domain.harbour.Harbour;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "locationAddress", target = "address")
    @Mapping(source = "locationLongitude", target = "longitude")
    @Mapping(source = "locationLatitude", target = "latitude")
    Location toLocation(HarbourDetailedInfo harbourDetailedInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "locationLatitude", target = "latitude")
    @Mapping(source = "locationLongitude", target = "longitude")
    @Mapping(source = "locationAddress", target = "address")
    Location partialUpdate(HarbourDetailedInfo harbourDetailedInfo, @MappingTarget Location location);

}