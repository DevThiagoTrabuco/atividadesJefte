package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
public class EnderecoModel {
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

    @Enumerated(EnumType.STRING)
    private UnidadeFederativa unidadeFederativa;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "complemento")
    private String complemento;

    @JsonBackReference("cliente-endereco")
    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private ClienteModel cliente;

    @JsonBackReference("familiar-endereco")
    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private FamiliarModel familiar;

    @JsonBackReference("funcionario-endereco")
    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private FuncionarioModel funcionario;
}
