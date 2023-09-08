package com.example.purjepaus.business.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.Harbour}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarbourDetailedInfo implements Serializable {
    private Integer harbourId;
    private String locationAddress;
    private BigDecimal locationLongitude;
    private BigDecimal locationLatitude;
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

    private List<ExtraInfo> extras;

    private List<String> pictures;
}