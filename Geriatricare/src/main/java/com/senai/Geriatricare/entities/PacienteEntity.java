package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class PacienteEntity {
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
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private StatusPaciente statusPaciente;

    @Column(name = "plano", nullable = false)
    private String plano;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<PrescricaoEntity> prescricoes;

    @ManyToMany
    @JoinTable(
        name = "paciente_familiar",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "familiar_id")
    )
    private List<FamiliarEntity> familiares;
}
