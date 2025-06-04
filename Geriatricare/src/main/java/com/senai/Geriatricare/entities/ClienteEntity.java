package com.senai.Geriatricare.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private EnderecoEntity endereco;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private AdminEntity admin;
}
