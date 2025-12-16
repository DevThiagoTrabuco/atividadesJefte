package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.Geriatricare.enums.Funcao;
import com.senai.Geriatricare.enums.StatusFuncionario;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "registro_profissional", nullable = false, unique = true)
    private String registro;

    @Enumerated(EnumType.STRING)
    private UnidadeFederativa unidadeFederativa;

    @Enumerated(EnumType.STRING)
    private StatusFuncionario statusFuncionario;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany(
            mappedBy = "funcionario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ConsultaModel> consultas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private EnderecoModel endereco;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

}
