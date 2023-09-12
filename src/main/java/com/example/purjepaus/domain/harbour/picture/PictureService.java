package com.example.purjepaus.domain.harbour.picture;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;


    public void savePicture(Picture picture) {
        pictureRepository.save(picture);
    }
}
