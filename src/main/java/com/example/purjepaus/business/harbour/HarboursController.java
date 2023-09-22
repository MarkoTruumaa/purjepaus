package com.example.purjepaus.business.harbour;

import com.example.purjepaus.business.harbour.dto.HarbourSearchInfo;
import com.example.purjepaus.business.harbour.dto.UpdateHarbourAndExtras;
import com.example.purjepaus.business.harbour.extra.ExtraInfo;
import com.example.purjepaus.business.user.dto.ContactInfo;
import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import com.example.purjepaus.business.harbour.dto.HarbourMainInfo;
import com.example.purjepaus.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/harbour/extras")
    @Operation(
            summary = "Leiab süsteemist (andmebaasist extra tabelist) kõik teenused.",
            description = "Tagastab info koos extrayId, extraName-i ja boolean isAvailable'iga")
    public List<ExtraInfo> getHarbourExtras() {
        return harboursService.getHarbourExtras();
    }

    @PostMapping("/harbour")
    @Operation(summary = "Uue sadama lisamine süsteemi.",
            description = "homepage ja picture pole kohustuslikud väljad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega sadam on süsteemis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addNewHarbour(@RequestBody HarbourDetailedInfo harbourDetailedInfo) {
        harboursService.addNewHarbour(harbourDetailedInfo);
    }

    @PutMapping("/harbour")
    @Operation(summary = "Muudab sadama andmeid süsteemis",
            description = "Leiab harbourId abil sadama andmed ja muudab need request body-is oleva info alusel")
    public void updateHarbourInfo(@RequestParam Integer harbourId, @RequestBody HarbourDetailedInfo harbourDetailedInfo) {
        harboursService.updateHarbourInfo(harbourId, harbourDetailedInfo);
    }

    @DeleteMapping("/harbour")
    @Operation(summary = "Eemaldab sadama info",
            description = "Muudab ära sadama staatuse active -> deleted")
    public void deleteHarbour(@RequestParam Integer harbourId) {
        harboursService.deleteHarbour(harbourId);
    }

    @PostMapping("/harbours/search")
    @Operation(summary = "Otsin süsteemist sisestatud parameetrite järgi välja sadamad",
            description = "Otsib süsteemist valitud teenuste, countyName-i, minDetpth ja minWidth järgi välja sadamad")
    public List<HarbourMainInfo> searchHarbours(@RequestBody HarbourSearchInfo harbourSearchInfo) {
        return harboursService.searchHarbours(harbourSearchInfo);
    }
}
