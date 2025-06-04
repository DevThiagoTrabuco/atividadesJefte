package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.Parentesco;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "familiares")
@Getter
@Setter
public class FamiliarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "familiar_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Parentesco parentesco;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToMany(mappedBy = "familiares", cascade = CascadeType.ALL)
    private List<PacienteEntity> pacientes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private EnderecoEntity endereco;
}
