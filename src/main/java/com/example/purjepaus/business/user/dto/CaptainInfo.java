package com.example.purjepaus.business.user.dto;

import com.example.purjepaus.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptainInfo implements Serializable {
    private Integer contactId;
    private String contactFirstName;
    private String contactLastName;
}