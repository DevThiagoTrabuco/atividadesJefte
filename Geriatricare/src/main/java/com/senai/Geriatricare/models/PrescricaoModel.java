package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senai.Geriatricare.enums.Posologia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private ClienteModelModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonBackReference
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private MedicamentoModel medicamento;

    @Enumerated(EnumType.STRING)
    private Posologia posologia;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "quantidade")
    private int quantidade;
}
