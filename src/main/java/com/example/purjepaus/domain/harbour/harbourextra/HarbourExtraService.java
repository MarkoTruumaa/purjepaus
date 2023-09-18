package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.domain.harbour.extra.Extra;
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

    public void saveHarbourExtra(HarbourExtra harbourExtra) {
        harbourExtraRepository.save(harbourExtra);
    }

    public HarbourExtra findHarbourExtraBy(Integer harbourId, Integer extraId) {
        return harbourExtraRepository.findHarbourExtraBy(harbourId, extraId);
    }

    public List<Integer> findHarbourIdsBy(List<Integer> extraIds, int countOfExtraIds) {
        return harbourExtraRepository.findHarboursIdsByMatching(extraIds, countOfExtraIds);
    }
}
