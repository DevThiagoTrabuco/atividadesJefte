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
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicamentos_id_fk", referencedColumnName = "medicamentos_id")
    private Medicamento medicamento;
}
