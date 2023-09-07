package com.example.purjepaus.domain.harbour.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourPictureRepository extends JpaRepository<HarbourPicture, Integer> {
    @Query("select h from HarbourPicture h where h.harbor.id = ?1")
    List<HarbourPicture> findByHarbor_Id(Integer id);


}