package com.example.purjepaus.domain.harbour.location.county;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountyRepository extends JpaRepository<County, Integer> {
    @Query("select c from County c where c.name = ?1")
    County findCountyBy(String countyName);

}