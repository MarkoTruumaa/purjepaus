package com.example.purjepaus.business.counties;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.location.county.County}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyInfo implements Serializable {
    private Integer countyId;
    @NotNull
    @Size(max = 255)
    private String countyName;
}