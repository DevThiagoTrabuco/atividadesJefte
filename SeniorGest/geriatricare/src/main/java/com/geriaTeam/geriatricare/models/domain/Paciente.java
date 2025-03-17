package com.geriaTeam.geriatricare.models.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Paciente {
    private int id;
    private String nome;
    private LocalDate nascimento;
    private LocalDateTime entrada;
    private String condMental;
    private String condFisica;
}