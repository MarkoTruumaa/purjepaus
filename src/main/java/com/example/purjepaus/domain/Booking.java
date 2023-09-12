package com.example.purjepaus.domain;

import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.user.User;
import com.example.purjepaus.domain.user.Vessel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vessel_id", nullable = false)
    private Vessel vessel;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "harbour_id", nullable = false)
    private Harbour harbour;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private LocalDate startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private LocalDate endTime;

}