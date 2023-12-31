package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.business.harbour.dto.HarbourSearchInfo;
import com.example.purjepaus.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.purjepaus.business.Status.*;

@Service
public class HarbourService {

    @Resource
    private HarbourRepository harbourRepository;


    public List<Harbour> getActiveHarboursInfo() {
        return harbourRepository.findHarboursBy(ACTIVE.getLetter());
    }

    public Harbour getHarbourInfoBy(Integer harbourId) {
        return harbourRepository.getReferenceById(harbourId);
    }

    public void confirmHarbourNameAvailability(String harbourName) {
        boolean nameExists = harbourRepository.nameExistsBy(harbourName);
        ValidationService.validateHarbourNameAvailability(nameExists);
    }

    public void saveHarbour(Harbour harbour) {
        harbourRepository.save(harbour);
    }

    public List<Harbour> findActiveHarboursBy(List<Integer> harbourIds) {
        return harbourRepository.findHarboursBy(harbourIds, ACTIVE.getLetter());
    }
}
