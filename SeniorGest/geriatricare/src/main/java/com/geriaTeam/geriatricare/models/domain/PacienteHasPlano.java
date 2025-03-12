package com.geriaTeam.geriatricare.models.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PacienteHasPlano")
public class PacienteHasPlano {
    @ManyToOne
    @MapsId("planoId")
    @JoinColumn(name = "Plano_idPlano")
    private Plano plan;

    @ManyToOne
    @MapsId("pacienteId")
    @JoinColumn(name = "Paciente_idPaciente")
    private Paciente pacient;

    @Column(name = "pagamentoPlano")
    private boolean isPayed;

    @Column(name = "vencimentoPlano")
    private LocalDateTime isDue;
}
