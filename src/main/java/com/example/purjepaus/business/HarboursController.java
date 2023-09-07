package com.example.purjepaus.business;

import com.example.purjepaus.business.dtos.HarbourDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HarboursController {

    @Resource
    private HarboursService harboursService;

    @GetMapping("/sadamad")
    @Operation(summary = "Tagastab sadamate info(nimi, kordinaadid, miinimum sügavus, miinimum laius, kohtade arv)",
            description = """
               Süsteemist otsitakse välja kõik aktiivsed sadamad""")
    public List<HarbourDto> getHarboursInfo() {
       return harboursService.getHarboursInfo();
    }
}
