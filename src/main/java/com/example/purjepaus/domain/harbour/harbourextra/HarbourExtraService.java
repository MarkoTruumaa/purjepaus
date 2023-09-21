package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.business.harbour.dto.HarbourSearchInfo;
import com.example.purjepaus.domain.harbour.Harbour;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarbourExtraService {

    @Resource
    private HarbourExtraRepository harbourExtraRepository;

    public List<HarbourExtra> findExtrasBy(Integer harbourId) {
        return harbourExtraRepository.findHarbourExtrasBy(harbourId);
    }

    public void saveHarbourExtra(HarbourExtra harbourExtra) {
        harbourExtraRepository.save(harbourExtra);
    }

    public HarbourExtra findHarbourExtraBy(Integer harbourId, Integer extraId) {
        return harbourExtraRepository.findHarbourExtraBy(harbourId, extraId);
    }

    public List<Harbour> findHarboursBy(List<Integer> extraIds, HarbourSearchInfo harbourSearchInfo) {
        int countOfExtraIds = extraIds.size();
        return harbourExtraRepository.findHarboursIdsByMatching(
                extraIds, countOfExtraIds, harbourSearchInfo.getCountyId(),
                harbourSearchInfo.getMinDepth(), harbourSearchInfo.getMinWidth());
    }
}
