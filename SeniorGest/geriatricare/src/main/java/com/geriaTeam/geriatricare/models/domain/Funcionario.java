package com.geriaTeam.geriatricare.models.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Funcionario {
    private int id;
    private String nome;
    private LocalDate nascimento;
    private int telefone;
    private String email;
    private int funcao;
}
