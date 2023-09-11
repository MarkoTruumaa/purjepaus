package com.example.purjepaus.business;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.purjepaus.domain.user.contact.Contact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo implements Serializable {
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
    @NotNull
    @Size(max = 255)
    private String email;
    @Size(max = 255)
    private String telephone;
    @Size(max = 255)
    private String address;
}