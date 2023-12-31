package com.example.purjepaus.domain.harbour.extra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraService {

    @Resource
    private ExtraRepository extraRepository;

    public Extra getExtraBy(Integer extraId) {
        return extraRepository.getReferenceById(extraId);
    }

    public List<Extra> getExtras() {
        return extraRepository.findAll();
    }
}
