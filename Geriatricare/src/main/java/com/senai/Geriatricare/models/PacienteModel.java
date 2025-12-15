package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "observacoes", nullable = false)
    private List<String> observacoes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusPaciente statusPaciente;

    @Column(name = "plano", nullable = false)
    private String plano;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private PlanoModel planoAssociado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @OneToMany(
            mappedBy = "paciente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ConsultaModel> consultas = new ArrayList<>();

    @OneToMany(
            mappedBy = "paciente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ContasAPagarModel> contasAPagar = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "paciente_familiar",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "familiar_id")
    )
    private List<FamiliarModel> familiares = new ArrayList<>();
}
