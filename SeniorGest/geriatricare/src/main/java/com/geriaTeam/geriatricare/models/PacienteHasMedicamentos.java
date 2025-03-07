package com.geriaTeam.geriatricare.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
