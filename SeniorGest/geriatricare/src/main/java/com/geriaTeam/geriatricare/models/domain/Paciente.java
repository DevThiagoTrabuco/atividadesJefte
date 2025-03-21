package com.geriaTeam.geriatricare.models.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_id")
    private int id;

    @Column(name = "pacientes_nome")
    private String nome;

    @Column(name = "pacientes_nascimento")
    private LocalDate nascimento;

    @Column(name = "pacientes_entrada")
    private LocalDateTime entrada;

    @Column(name = "pacientes_condMental")
    private String condMental;

    @Column(name = "pacientes_condFisica")
    private String condFisica;
}