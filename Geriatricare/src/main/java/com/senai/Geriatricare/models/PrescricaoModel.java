package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.Geriatricare.enums.Posologia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prescricoes")
@Getter
@Setter
public class PrescricaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescricao_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonBackReference
    private PacienteModel paciente;

    @Column(name = "medicamento", nullable = false)
    private String medicamento;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "observacoes")
    private List<String> observacoes  = new ArrayList();

    @Enumerated(EnumType.STRING)
    @Column(name = "posologia", nullable = false)
    private Posologia posologia;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "quantidade")
    private int quantidade;
}
