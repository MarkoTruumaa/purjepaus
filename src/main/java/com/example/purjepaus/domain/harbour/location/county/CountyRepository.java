package com.example.purjepaus.domain.harbour.location.county;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountyRepository extends JpaRepository<County, Integer> {
    @Query("select c from County c where upper(c.name) = upper(:countyName)")
    County findCountyBy(String countyName);

}