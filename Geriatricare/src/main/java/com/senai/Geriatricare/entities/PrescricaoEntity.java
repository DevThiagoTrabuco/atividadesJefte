package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.Posologia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescricoes")
@Getter
@Setter
public class PrescricaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescricao_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private MedicamentoEntity medicamento;

    @Enumerated(EnumType.STRING)
    private Posologia posologia;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;
}
