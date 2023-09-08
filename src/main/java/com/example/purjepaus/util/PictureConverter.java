package com.example.purjepaus.util;

import com.example.purjepaus.domain.harbour.picture.Picture;

import java.nio.charset.StandardCharsets;

public class PictureConverter {

    public static Picture pictureDataToPicture(String pictureData) {
        byte[] bytes = getBytesArrayFromPictureData(pictureData);
        Picture picture = new Picture();
        picture.setPictureData(bytes);
        return picture;
    }

    public static byte[] getBytesArrayFromPictureData(String pictureData) {
        return pictureData.getBytes(StandardCharsets.UTF_8);
    }

    public static String pictureToPictureData(Picture picture) {
        if (picture == null) {
            return "";
        }
        return new String(picture.getPictureData(), StandardCharsets.UTF_8);
    }


}
