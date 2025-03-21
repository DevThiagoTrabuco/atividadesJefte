package com.geriaTeam.geriatricare.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Sinais_Vitais")
public class SinaisVitais {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Sinais_Viatis_id")
    private int id;

    @Column(name = "Sinais_Vitais_batimento")
    private int batimentos;

    @Column(name = "Sinais_Vitais_oximetria")
    private int oximetria;

    @Column(name = "Sinais_Vitais_temperatura")
    private int temperatura;
}
