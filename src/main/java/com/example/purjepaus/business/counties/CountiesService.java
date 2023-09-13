package com.example.purjepaus.business.counties;

import com.example.purjepaus.domain.harbour.location.county.County;
import com.example.purjepaus.domain.harbour.location.county.CountyMapper;
import com.example.purjepaus.domain.harbour.location.county.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountiesService {

    @Resource
    private CountyService countyService;
    @Resource
    private CountyMapper countyMapper;

    public List<CountyInfo> getCounties() {
        List<County> counties = countyService.getCounties();
        return countyMapper.toCountiesInfo(counties);
    }
}
