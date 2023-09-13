package com.example.purjepaus.business.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.purjepaus.domain.user.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUpdate implements Serializable {


    @NotNull
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(max = 255)
    private String contactFirstName;
    @NotNull
    @Size(max = 255)
    private String contactLastName;
    @NotNull
    @Size(max = 255)
    private String contactEmail;
    @Size(max = 255)
    private String contactTelephone;
    @Size(max = 255)
    private String contactAddress;
}