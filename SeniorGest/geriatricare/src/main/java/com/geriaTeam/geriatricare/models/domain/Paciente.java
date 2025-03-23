package com.geriaTeam.geriatricare.models.domain;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_id")
    private int id;

    @Column(name = "pacientes_nome")
    private String nome;

    @Column(name = "pacientes_nascimento")
    private LocalDateTime nascimento;

    @Column(name = "pacientes_entrada")
    private LocalDateTime entrada;

    @Column(name = "pacientes_cond_mental")
    private String condMental;

    @Column(name = "pacientes_cond_fisica")
    private String condFisica;

    public Paciente() {

    }

    public Paciente(String nome, LocalDateTime nascimento, LocalDateTime entrada, String condMental, String condFisica) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.entrada = entrada;
        this.condMental = condMental;
        this.condFisica = condFisica;
    }

    public Paciente(int id, String nome, LocalDateTime nascimento, LocalDateTime entrada, String condMental, String condFisica) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.entrada = entrada;
        this.condMental = condMental;
        this.condFisica = condFisica;
    }
}