package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque_produto") // Tabela de junção com atributos
@Getter
@Setter
public class EstoqueProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_produto_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estoque_geral_id", nullable = false)
    @JsonBackReference("estoque-produtos")
    private EstoqueGeralModel estoqueGeral;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    @JsonBackReference("produto-estoques")
    private ProdutoModel produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

}