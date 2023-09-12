package com.example.purjepaus.domain.harbour.location;

import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "locationAddress", target = "address")
    @Mapping(source = "locationLongitude", target = "longitude")
    @Mapping(source = "locationLatitude", target = "latitude")
    Location toLocation(HarbourDetailedInfo harbourDetailedInfo);


}