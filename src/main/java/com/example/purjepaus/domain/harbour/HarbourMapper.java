package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.business.dtos.HarbourDto;
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
    HarbourDto toHarbourDto(Harbour harbour);

    List<HarbourDto> toHarbourDtos(List<Harbour> harbours);
}