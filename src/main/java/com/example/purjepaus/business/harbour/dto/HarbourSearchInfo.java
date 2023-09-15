package com.example.purjepaus.business.harbour.dto;

import com.example.purjepaus.business.harbour.extra.ExtraInfo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.example.purjepaus.domain.harbour.Harbour}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarbourSearchInfo implements Serializable {

    private String locationCountyName;

    private BigDecimal minDepth;

    private BigDecimal minWidth;

    private List<ExtraInfo> extras;
}