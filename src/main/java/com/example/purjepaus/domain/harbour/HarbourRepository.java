package com.example.purjepaus.domain.harbour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourRepository extends JpaRepository<Harbour, Integer> {

    @Query("select h from Harbour h where h.status = ?1 order by h.name")
    List<Harbour> findHarboursBy(String status);

}