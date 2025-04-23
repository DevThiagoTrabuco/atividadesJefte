package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteFamiliar {

    private int id;
    private PacienteModels pacienteModels;
    private int pacienteId;
    private FamiliarModels familiarModels;
    private int familiarId;

    // Método para validar o ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método para validar o pacienteId
    public static boolean validarPacienteId(int pacienteId) {
        return pacienteId > 0;
    }

    // Método para validar o familiarId
    public static boolean validarFamiliarId(int familiarId) {
        return familiarId > 0;
    }

    // Método para converter a entidade PacienteFamiliar para PacienteFamiliarModels
    public PacienteFamiliarModels toModel() {
        PacienteFamiliarModels pacienteFamiliarModels = new PacienteFamiliarModels();
        pacienteFamiliarModels.setPacienteId(this.pacienteId);
        pacienteFamiliarModels.setFamiliarId(this.familiarId);
        return pacienteFamiliarModels;
    }
}