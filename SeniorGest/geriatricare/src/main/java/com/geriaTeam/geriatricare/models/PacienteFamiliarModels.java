package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PacienteFamiliarModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_familiares_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private PacienteModels pacienteModels;

    @Column(name = "pacientes_id_fk", insertable = false, updatable = false)
    private int pacienteId;

    @ManyToOne
    @JoinColumn(name = "familiares_id_fk", referencedColumnName = "familiares_id")
    private FamiliarModels familiarModels;

    @Column(name = "familiares_id_fk", insertable = false, updatable = false)
    private int familiarId;
}
