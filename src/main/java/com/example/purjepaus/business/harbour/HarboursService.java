package com.example.purjepaus.business.harbour;

import com.example.purjepaus.business.dtos.ExtraInfo;
import com.example.purjepaus.business.dtos.HarbourDetailedInfo;
import com.example.purjepaus.business.dtos.HarbourMainInfoDto;
import com.example.purjepaus.domain.HarbourExtraService;
import com.example.purjepaus.domain.harbour.extra.Extra;
import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.harbour.HarbourMapper;
import com.example.purjepaus.domain.harbour.HarbourService;
import com.example.purjepaus.domain.harbour.extra.ExtraMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarboursService {

    @Resource
    private HarbourService harbourService;
    @Resource
    private HarbourMapper harbourMapper;
    @Resource
    private ExtraMapper extraMapper;
    @Resource
    private HarbourExtraService harbourExtraService;




    public List<HarbourMainInfoDto> getHarboursInfo() {
        List<Harbour> harbours = harbourService.getActiveHarboursInfo();
        return harbourMapper.toHarbourDtos(harbours);
    }

    public HarbourDetailedInfo getHarbourInfo(Integer harbourId) {
        Harbour harbour = harbourService.getHarbourInfoBy(harbourId);
        HarbourDetailedInfo harbourDetailedInfoDto = harbourMapper.toHarbourDetailedInfoDto(harbour);

        List<Extra> extras = harbourExtraService.findExtrasBy(harbourId);
        List<ExtraInfo> extraInfos = extraMapper.toExtraInfos(extras);


        harbourDetailedInfoDto.setExtras(extraInfos);

        return harbourDetailedInfoDto;
    }
}
