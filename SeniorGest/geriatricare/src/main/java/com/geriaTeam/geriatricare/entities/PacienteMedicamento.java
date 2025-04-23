package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.MedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteMedicamento {
    private int id;
    private PacienteModels pacienteModels;
    private int pacienteId;
    private MedicamentoModels medicamentoModels;
    private int medicamentoId;

    // Método para validar o ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método para validar o pacienteId
    public static boolean validarPacienteId(int pacienteId) {
        return pacienteId > 0;
    }

    // Método para validar o medicamentoId
    public static boolean validarMedicamentoId(int medicamentoId) {
        return medicamentoId > 0;
    }

    // Método para converter a entidade PacienteMedicamento para PacienteMedicamentoModels
    public PacienteMedicamentoModels toModel() {
        PacienteMedicamentoModels pacienteMedicamentoModels = new PacienteMedicamentoModels();
        pacienteMedicamentoModels.setPacienteId(this.pacienteId);
        pacienteMedicamentoModels.setMedicamentoId(this.medicamentoId);
        return pacienteMedicamentoModels;
    }
}