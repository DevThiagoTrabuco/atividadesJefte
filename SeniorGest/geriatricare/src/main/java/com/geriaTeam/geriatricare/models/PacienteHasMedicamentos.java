package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "paciente_has_medicamentos")
public class PacienteHasMedicamentos {
    @ManyToOne
    @MapsId("pacienteId")
    @JoinColumn(name = "Paciente_idPaciente")
    private Paciente pacient;

    @ManyToOne
    @MapsId("medicamentoId")
    @JoinColumn(name = "Medicamentos_idMedicamentos")
    private Medicamentos medicine;

    @Column(name = "horario_medicamentos")
    private LocalDateTime schedule;

    @Column(name = "dose_medicamentos")
    private int dosage;

    public PacienteHasMedicamentos(Paciente pacient, Medicamentos medicine, LocalDateTime schedule, int dosage) {
        this.pacient = pacient;
        this.medicine = medicine;
        this.schedule = schedule;
        this.dosage = dosage;
    }

    public PacienteHasMedicamentos() {
    }

    public Paciente getPacient() {
        return pacient;
    }

    public void setPacient(Paciente pacient) {
        this.pacient = pacient;
    }

    public Medicamentos getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicamentos medicine) {
        this.medicine = medicine;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}
