package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PlanoHasPaciente")
public class PlanoHasPaciente {
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

    public PlanoHasPaciente(Plano plan, Paciente pacient, boolean isPayed, LocalDateTime isDue) {
        this.plan = plan;
        this.pacient = pacient;
        this.isPayed = isPayed;
        this.isDue = isDue;
    }

    public PlanoHasPaciente() {
    }

    public Plano getPlan() {
        return plan;
    }

    public void setPlan(Plano plan) {
        this.plan = plan;
    }

    public Paciente getPacient() {
        return pacient;
    }

    public void setPacient(Paciente pacient) {
        this.pacient = pacient;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public LocalDateTime getIsDue() {
        return isDue;
    }

    public void setIsDue(LocalDateTime isDue) {
        this.isDue = isDue;
    }
}
