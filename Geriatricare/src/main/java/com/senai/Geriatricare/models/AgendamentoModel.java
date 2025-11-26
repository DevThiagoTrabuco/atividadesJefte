package com.senai.Geriatricare.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel paciente;

    @Column(name = "data_agendamento", nullable = false)
    private LocalDateTime data;

    @Column(name = "procedimento", nullable = false)
    private String procedimento;
}
