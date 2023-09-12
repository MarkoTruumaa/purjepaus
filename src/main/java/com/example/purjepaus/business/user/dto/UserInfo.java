package com.example.purjepaus.business.user.dto;

import com.example.purjepaus.domain.user.contact.Contact;
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
public class UserInfo implements Serializable {

    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
    @NotNull
    private String roleName;
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
    @NotNull
    private Boolean contactIsCaptain = false;
}