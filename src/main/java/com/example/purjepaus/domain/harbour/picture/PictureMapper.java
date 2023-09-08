package com.example.purjepaus.domain.harbour.picture;

import com.example.purjepaus.business.harbour.picture.PictureDto;
import com.example.purjepaus.util.PictureConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {PictureConverter.class})
public interface PictureMapper {

    @Mapping(source = "id", target = "pictureId")
    @Mapping(expression = "java(PictureConverter.byteArrayToString(picture.getPictureData()))", target = "pictureData")
    PictureDto toPictureDto(Picture picture);


    List<PictureDto> toPictureDtos(List<Picture> pictures);

}