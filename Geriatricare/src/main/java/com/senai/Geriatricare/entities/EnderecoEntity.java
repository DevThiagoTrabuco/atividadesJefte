package com.senai.Geriatricare.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private int id;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "UF", nullable = false)
    private String UF;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "complemento")
    private String complemento;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private ClienteEntity cliente;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private FamiliarEntity familiar;
}
