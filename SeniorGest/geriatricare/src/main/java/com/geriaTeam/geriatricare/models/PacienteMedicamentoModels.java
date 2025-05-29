package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

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

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id", insertable = false, updatable = false)
    private PacienteModels pacienteModels;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "medicamentos_id_fk", referencedColumnName = "medicamentos_id", insertable = false, updatable = false)
    private MedicamentoModels medicamentoModels;

    @Column(name = "medicamentos_id_fk")
    private int medicamentoId;

    @Column(name = "pacientes_id_fk")
    private int pacienteId;
}
