package com.example.purjepaus.domain.harbour.harborpicture;

import com.example.purjepaus.domain.harbour.picture.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourPictureRepository extends JpaRepository<HarbourPicture, Integer> {
    @Query("select h.picture from HarbourPicture h where h.harbor.id = ?1")
    List<Picture> findPicturesBy(Integer harbourId);


}