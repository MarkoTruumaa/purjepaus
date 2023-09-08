package com.example.purjepaus.domain.harbour.extra;

import com.example.purjepaus.business.harbour.extra.ExtraInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExtraMapper {


    @Mapping(source = "id", target = "extraId")
    @Mapping(source = "name", target = "extraName")
    ExtraInfo toExtraInfos(Extra extra);

   List<ExtraInfo> toExtraInfos(List<Extra> extras);

}