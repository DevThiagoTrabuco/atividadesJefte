package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sinais_vitais")
public class SinaisVitais {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "sinais_vitais_id")
    private int id;

    @Column(name = "sinais_vitais_batimento")
    private int batimentos;

    @Column(name = "sinais_vitais_oximetria")
    private int oximetria;

    @Column(name = "sinais_vitais_temperatura")
    private int temperatura;
}
