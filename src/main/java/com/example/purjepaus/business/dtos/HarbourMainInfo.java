package com.example.purjepaus.business.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.Harbour}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarbourMainInfo implements Serializable {

    private Integer harbourId;

    @NotNull
    @Size(max = 255)
    private String harbourName;

    private BigDecimal locationLongitude;

    private BigDecimal locationLatitude;

    @NotNull
    private BigDecimal minDepth;
    @NotNull
    private BigDecimal minWidth;
    @NotNull
    private Integer spots;
}