package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.Geriatricare.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel paciente;

    @Column(name = "data_agendamento", nullable = false)
    private LocalDate data;

    @Column(name = "hora_agendamento", nullable = false)
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @Column(name = "procedimento", nullable = false)
    private String procedimento;
}
