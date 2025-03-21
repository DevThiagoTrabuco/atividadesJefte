package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarios_id")
    private int id;

    @Column(name = "funcionarios_nome")
    private String nome;

    @Column(name = "funcionarios_nascimento")
    private LocalDate nascimento;

    @Column(name = "funcionarios_telefone")
    private int telefone;

    @Column(name = "funcionarios_email")
    private String email;

    @Column(name = "funcionarios_funcao")
    private int funcao;
}
