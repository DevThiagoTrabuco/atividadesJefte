package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senai.Geriatricare.enums.TipoConta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "contas_a_receber")
@Getter
@Setter
public class ContasAReceber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contas_a_receber_id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_recebimento")
    private LocalDate dataRecebimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference("cliente-contas-receber")
    private ClienteModelModel cliente;
}