package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.domain.harbour.extra.Extra;
import com.example.purjepaus.domain.harbour.harbourextra.HarbourExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourExtraRepository extends JpaRepository<HarbourExtra, Integer> {
    @Query("select h.extra from HarbourExtra h where h.harbour.id = ?1")
    List<Extra> findExtrasBy(Integer harbourId);


}