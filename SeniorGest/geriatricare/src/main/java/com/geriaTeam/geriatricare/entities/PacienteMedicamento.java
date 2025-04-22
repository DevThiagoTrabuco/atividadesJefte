package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.MedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.Interfaces.PacienteMedicamentoRepository;
import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PacienteMedicamento {
    private int id;
    private PacienteModels pacienteModels;
    private int pacienteId;
    private MedicamentoModels medicamentoModels;
    private int medicamentoId;

    // Método para converter a entidade PacienteMedicamento para PacienteMedicamentoModels
    public PacienteMedicamentoModels toModel() {
        PacienteMedicamentoModels pacienteMedicamentoModels = new PacienteMedicamentoModels();
        pacienteMedicamentoModels.setPacienteId(this.pacienteId);
        pacienteMedicamentoModels.setMedicamentoId(this.medicamentoId);
        return pacienteMedicamentoModels;
    }
}
