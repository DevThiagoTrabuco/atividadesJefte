package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PacienteHasPlano")
public class PacienteHasPlano {
    @ManyToOne
    @MapsId("pacienteId")
    @JoinColumn(name = "Paciente_idPaciente")
    private Paciente pacient;

    @ManyToOne
    @MapsId("planoId")
    @JoinColumn(name = "Plano_idPlano")
    private Plano plan;

    public PacienteHasPlano(UUID pacienteId, UUID planoId, Paciente pacient, Plano plan) {
        this.pacient = pacient;
        this.plan = plan;
    }

    public PacienteHasPlano() {
    }

    public Paciente getPacient() {
        return pacient;
    }

    public void setPacient(Paciente pacient) {
        this.pacient = pacient;
    }

    public Plano getPlan() {
        return plan;
    }

    public void setPlan(Plano plan) {
        this.plan = plan;
    }
}
