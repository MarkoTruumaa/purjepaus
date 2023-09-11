package com.example.purjepaus.domain.harbour;

import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.harbour.location.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "harbour")
public class Harbour {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "homepage")
    private String homepage;

    @NotNull
    @Column(name = "navigation_start", nullable = false)
    private LocalDate navigationStart;

    @NotNull
    @Column(name = "navigation_end", nullable = false)
    private LocalDate navigationEnd;

    @NotNull
    @Column(name = "min_depth", nullable = false, precision = 4, scale = 2)
    private BigDecimal minDepth;

    @NotNull
    @Column(name = "min_width", nullable = false, precision = 4, scale = 2)
    private BigDecimal minWidth;

    @NotNull
    @Column(name = "spots", nullable = false)
    private Integer spots;

    @Size(max = 255)
    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}