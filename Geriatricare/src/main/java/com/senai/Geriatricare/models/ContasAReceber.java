package com.senai.Geriatricare.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    @Column(name = "cliente")
    private ClienteModel cliente;

    @Column(name = "paciente")
    private PacienteModel paciente;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_vencimento")
    private Date dataVencimento;

}
