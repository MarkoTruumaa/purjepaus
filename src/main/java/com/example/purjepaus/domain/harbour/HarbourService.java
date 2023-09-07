package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarbourService {

    @Resource
    private HarbourRepository harbourRepository;


    public List<Harbour> getActiveHarboursInfo() {
        return harbourRepository.findHarboursBy(Status.ACTIVE.getLetter());
    }

    public Harbour getHarbourInfoBy(Integer harbourId) {
        return harbourRepository.getReferenceById(harbourId);
    }
}
