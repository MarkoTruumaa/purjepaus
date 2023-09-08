package com.example.purjepaus.domain.harbour.harborpicture;

import com.example.purjepaus.domain.harbour.picture.Picture;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarbourPictureService {

    @Resource
    private HarbourPictureRepository harbourPictureRepository;

    public List<Picture> findPicturesBy(Integer harbourId) {
        return harbourPictureRepository.findPicturesBy(harbourId);
    }
}
