package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PacienteFamiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_familiares_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "familiares_id_fk", referencedColumnName = "familiares_id")
    private Familiar familiar;
}
