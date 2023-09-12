package com.example.purjepaus.business.harbour;

import com.example.purjepaus.business.user.dto.ContactInfo;
import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import com.example.purjepaus.business.harbour.dto.HarbourMainInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HarboursController {

    @Resource
    private HarboursService harboursService;

    @GetMapping("/harbours")
    @Operation(summary = "Tagastab sadamate põhiinfo(nimi, koordinaadid, miinimum sügavus, miinimum laius, kohtade arv)",
            description = """
               Süsteemist otsitakse välja kõik aktiivsed sadamad""")
    public List<HarbourMainInfo> getHarboursInfo() {
       return harboursService.getHarboursInfo();
    }

    @GetMapping("/harbour")
    @Operation(summary = "Tagastab ühe sadama detailse/kogu info",
            description = """
               Süsteemist otsitakse harbourId põhjal välja kogu info ühe sadama kohta""")
    public HarbourDetailedInfo getHarbourInfo(@RequestParam Integer harbourId) {
        return harboursService.getHarbourInfo(harbourId);
    }

    @GetMapping("/harbour/captain-info")
    @Operation(summary = "Tagastab kapteni kontaktinfo",
            description = """
               Süsteemist otsitakse contactId põhjal välja kapteni kontaktinfo""")
    public ContactInfo getCaptainInfo(@RequestParam Integer contactId) {
        return harboursService.getCaptainContactInfo(contactId);
    }
}
