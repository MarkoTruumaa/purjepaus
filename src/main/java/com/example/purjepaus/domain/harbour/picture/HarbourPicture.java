package com.example.purjepaus.domain.harbour.picture;

import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.harbour.picture.Picture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "harbour_picture")
public class HarbourPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "picture_id", nullable = false)
    private Picture picture;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "harbor_id", nullable = false)
    private Harbour harbor;

}