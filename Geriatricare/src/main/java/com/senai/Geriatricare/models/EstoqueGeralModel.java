package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estoques_gerais") // Nome da tabela para o estoque geral
@Getter
@Setter
public class EstoqueGeralModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_geral_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false, unique = true)
    private ClienteModel cliente;

    @OneToMany(mappedBy = "estoqueGeral", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("estoque-produtos")
    private List<EstoqueProdutoModel> itensEstoque = new ArrayList<>();
}