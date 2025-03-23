package com.geriaTeam.geriatricare.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SinaisVitais {
    private int id;

    private int batimentos;

    private int oximetria;

    private int temperatura;

    private int idPaciente;
}
