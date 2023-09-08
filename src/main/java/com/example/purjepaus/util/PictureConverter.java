package com.example.purjepaus.util;

import com.example.purjepaus.domain.harbour.picture.Picture;

import java.nio.charset.StandardCharsets;

public class PictureConverter {

    public static Picture pictureDataToPicture(String pictureData) {
        byte[] bytes = stringToByteArray(pictureData);
        Picture picture = new Picture();
        picture.setPictureData(bytes);
        return picture;
    }

    public static byte[] stringToByteArray(String pictureData) {
        return pictureData.getBytes(StandardCharsets.UTF_8);
    }

    public static String pictureToPictureData(Picture picture) {
        if (picture == null) {
            return "";
        }
        return byteArrayToString(picture.getPictureData());
    }

    public static String byteArrayToString(byte[] pictureData) {
        return new String(pictureData, StandardCharsets.UTF_8);
    }


}
