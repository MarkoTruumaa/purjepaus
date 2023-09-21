package com.example.purjepaus.business.harbour.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.harbourextra.HarbourExtra}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarbourExtraInfo implements Serializable {
    private Integer extraId;
    private String extraName;
    @NotNull
    private Boolean isAvailable = false;
}