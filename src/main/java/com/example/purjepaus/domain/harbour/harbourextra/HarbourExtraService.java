package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.domain.harbour.extra.Extra;
import com.example.purjepaus.domain.harbour.harbourextra.HarbourExtraRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarbourExtraService {

    @Resource
    private HarbourExtraRepository harbourExtraRepository;

    public List<Extra> findExtrasBy(Integer harbourId) {
        return harbourExtraRepository.findExtrasBy(harbourId);
    }
}
