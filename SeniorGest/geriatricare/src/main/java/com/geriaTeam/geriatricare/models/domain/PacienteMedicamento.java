package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PacienteMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_medicamentos_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id", insertable = false, updatable = false)
    private Paciente paciente;

    @Column(name = "pacientes_id_fk")
    private int pacienteId;

    @ManyToOne
    @JoinColumn(name = "medicamentos_id_fk", referencedColumnName = "medicamentos_id", insertable = false, updatable = false)
    private Medicamento medicamento;

    @Column(name = "pacientes_id_fk")
    private int medicamentoId;
}
