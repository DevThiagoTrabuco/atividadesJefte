package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.enums.TipoConta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "contas_a_pagar")
@Getter
@Setter
public class ContasAPagarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contas_a_pagar_id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = "chave_NFE")
    private String chaveNFE;

    @Column(name = "serie_NFE")
    private String serieNFE;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @Enumerated(EnumType.STRING)
    private StatusConta statusConta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonBackReference("paciente-contas-pagar")
    private PacienteModel paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference("cliente-contas-pagar")
    private ClienteModel cliente;
}
