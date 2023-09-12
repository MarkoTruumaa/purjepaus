package com.example.purjepaus.domain.harbour.location.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CountyService {

    @Resource
    private CountyRepository countyRepository;

    public County getCountyBy(String countyName) {
        return countyRepository.findCountyBy(countyName);
    }
}
