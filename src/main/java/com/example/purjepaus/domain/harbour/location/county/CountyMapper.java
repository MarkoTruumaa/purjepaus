package com.example.purjepaus.domain.harbour.location.county;

import com.example.purjepaus.business.counties.CountyInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {


    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "name", target = "countyName")
    CountyInfo toCountiesInfo(County county);

    List<CountyInfo>  toCountiesInfo(List<County> counties);

}