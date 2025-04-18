package com.geriaTeam.geriatricare.models;

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
public class PacienteMedicamentoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_medicamentos_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id", insertable = false, updatable = false)
    private PacienteModels pacienteModels;

    @Column(name = "pacientes_id_fk")
    private int pacienteId;

    @ManyToOne
    @JoinColumn(name = "medicamentos_id_fk", referencedColumnName = "medicamentos_id", insertable = false, updatable = false)
    private MedicamentoModels medicamentoModels;

    @Column(name = "medicamentos_id_fk")
    private int medicamentoId;
}
