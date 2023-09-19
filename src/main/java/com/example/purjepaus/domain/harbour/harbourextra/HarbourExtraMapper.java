package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.business.HarbourExtraInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HarbourExtraMapper {


    @Mapping(source = "extra.id", target = "extraId")
    @Mapping(source = "extra.name", target = "extraName")
    HarbourExtraInfo toHarbourExtraInfo(HarbourExtra harbourExtra);

    List<HarbourExtraInfo> toHarbourExtrasInfo(List<HarbourExtra> harbourExtras);

}