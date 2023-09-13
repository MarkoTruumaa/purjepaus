package com.example.purjepaus.business.counties;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountiesController {

    @Resource
    private CountiesService countiesService;

    @GetMapping("/counties")
    @Operation(
            summary = "Leiab süsteemist (andmebaasist county tabelist) kõik maakonnad.",
            description = "Tagastab info koos countyId ja countyName'ga")
    public List<CountyInfo> getCounties() {
        return countiesService.getCounties();
    }
}
