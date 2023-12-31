package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.business.harbour.dto.HarbourSearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourRepository extends JpaRepository<Harbour, Integer> {

    @Query("select h from Harbour h where h.status = ?1 order by h.name")
    List<Harbour> findHarboursBy(String status);

    @Query("select (count(h) > 0) from Harbour h where upper(h.name) = upper(?1)")
    boolean nameExistsBy(String harbourName);

    @Query("select h from Harbour h where " +
            "h.id in :harbourIds and " +
            "h.status = :status order by h.name")
    List<Harbour> findHarboursBy(List<Integer> harbourIds, String status);


}