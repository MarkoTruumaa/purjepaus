package com.example.purjepaus.business.user;

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
public class NewUserInfo implements Serializable {
    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactTelephone;
    private String contactAddress;
    private Boolean contactIsCaptain = false;
    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
}