package com.example.purjepaus.business;

import com.example.purjepaus.business.dtos.HarbourDto;
import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.harbour.HarbourMapper;
import com.example.purjepaus.domain.harbour.HarbourService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarboursService {

    @Resource
    private HarbourService harbourService;

    @Resource
    private HarbourMapper harbourMapper;

    public List<HarbourDto> getHarboursInfo() {
        List<Harbour> harbours = harbourService.getActiveHarboursInfo();
        return harbourMapper.toHarbourDtos(harbours);
    }
}
