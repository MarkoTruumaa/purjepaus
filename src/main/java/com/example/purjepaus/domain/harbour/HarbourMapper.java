package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.business.dtos.HarbourDetailedInfo;
import com.example.purjepaus.business.dtos.HarbourMainInfoDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HarbourMapper {

    @Mapping(source = "id", target = "harbourId")
    @Mapping(source = "name", target = "harbourName")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "minDepth", target = "minDepth")
    @Mapping(source = "minWidth", target = "minWidth")
    @Mapping(source = "spots", target = "spots")
    HarbourMainInfoDto toHarbourDto(Harbour harbour);

    List<HarbourMainInfoDto> toHarbourDtos(List<Harbour> harbours);


    @Mapping(source = "id", target = "harbourId")
    @Mapping(source = "name", target = "harbourName")
    @Mapping(source = "spots", target = "spots")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "minWidth", target = "minWidth")
    @Mapping(source = "minDepth", target = "minDepth")
    @Mapping(source = "contact.id", target = "contactId")
    @Mapping(source = "homepage", target = "homepage")
    @Mapping(source = "location.address", target = "locationAddress")
    @Mapping(source = "navigationEnd", target = "navigationEnd")
    @Mapping(source = "navigationStart", target = "navigationStart")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    HarbourDetailedInfo toHarbourDetailedInfoDto(Harbour harbour);


}