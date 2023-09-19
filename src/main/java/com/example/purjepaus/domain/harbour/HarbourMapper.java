package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.business.Status;
import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import com.example.purjepaus.business.harbour.dto.HarbourMainInfo;
import com.example.purjepaus.business.harbour.dto.HarbourSearchInfo;
import com.example.purjepaus.business.harbour.dto.UpdateHarbourAndExtras;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface HarbourMapper {

    @Mapping(source = "id", target = "harbourId")
    @Mapping(source = "name", target = "harbourName")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    HarbourMainInfo toHarbourMainInfo(Harbour harbour);

    List<HarbourMainInfo> toHarboursMainInfo(List<Harbour> harbours);


    @Mapping(source = "name", target = "harbourName")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "contact.id", target = "contactId")
    @Mapping(source = "location.county.name", target = "locationCountyName")
    @Mapping(source = "location.address", target = "locationAddress")
    HarbourDetailedInfo toHarbourDetailedInfo(Harbour harbour);


    @Mapping(source = "harbourName", target = "name")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    Harbour toHarbour(HarbourDetailedInfo harbourDetailedInfo);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "harbourName", target = "name")
    Harbour partialUpdate(HarbourDetailedInfo harbourDetailedInfo, @MappingTarget Harbour harbour);

}