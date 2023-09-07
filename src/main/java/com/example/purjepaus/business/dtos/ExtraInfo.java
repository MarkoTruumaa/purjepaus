package com.example.purjepaus.business.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.extra.Extra}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtraInfo implements Serializable {
    private Integer extraId;
    @NotNull
    @Size(max = 255)
    private String extraName;

    private Boolean isAvailable = false;

}