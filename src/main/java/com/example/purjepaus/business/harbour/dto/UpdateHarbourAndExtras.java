package com.example.purjepaus.business.harbour.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.Harbour}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHarbourAndExtras implements Serializable {

    @NotNull
    private Integer locationCountyId;
    @NotNull
    @Size(max = 255)
    private String locationAddress;
    @NotNull
    private BigDecimal locationLongitude;
    @NotNull
    private BigDecimal locationLatitude;
    @NotNull
    private Integer contactId;
    @NotNull
    @Size(max = 255)
    private String harbourName;
    @Size(max = 255)
    private String homepage;
    @NotNull
    private LocalDate navigationStart;
    @NotNull
    private LocalDate navigationEnd;
    @NotNull
    private BigDecimal minDepth;
    @NotNull
    private BigDecimal minWidth;
    @NotNull
    private Integer spots;
    @NotNull
    @Size(max = 255)
    private String phoneNumber;
}