package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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
