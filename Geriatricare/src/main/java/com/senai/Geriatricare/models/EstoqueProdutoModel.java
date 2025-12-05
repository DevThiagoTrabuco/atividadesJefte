package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque_produto")
@Getter
@Setter
public class EstoqueProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_produto_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoModel produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estoque_paciente_id", nullable = true)
    @JsonBackReference("estoque-paciente-produtos")
    private EstoquePacienteModel estoquePaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estoque_geral_id", nullable = true)
    @JsonBackReference("estoque-geral-produtos")
    private EstoqueGeralModel estoqueGeral;
}
