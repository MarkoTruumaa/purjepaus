package com.example.purjepaus.domain.user;

import com.example.purjepaus.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "vessel")
public class Vessel {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "length", nullable = false, precision = 4, scale = 2)
    private BigDecimal length;

    @NotNull
    @Column(name = "width", nullable = false, precision = 4, scale = 2)
    private BigDecimal width;

    @NotNull
    @Column(name = "draft", nullable = false, precision = 3, scale = 2)
    private BigDecimal draft;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Size(max = 255)
    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

}