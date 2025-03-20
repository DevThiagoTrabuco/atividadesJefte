package com.geriaTeam.geriatricare.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SinaisVitais {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "batimentos")
    private int batimentos;

    @Column(name = "oximetria")
    private int oximetria;

    @Column(name = "temperatura")
    private int temperatura;

    @Column(name = "idPaciente")
    private int idPaciente;
}
