package com.geriaTeam.geriatricare.models.domain;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "paciente", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PacienteMedicamento> pacienteMedicamento;

    @OneToMany(mappedBy = "paciente", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PacienteFamiliar> pacienteFamiliar;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "planos_id_fk", referencedColumnName = "planos_id")
    private Plano plano;
}