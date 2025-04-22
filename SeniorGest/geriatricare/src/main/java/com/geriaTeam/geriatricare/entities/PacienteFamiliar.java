package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.Interfaces.PacienteRepository; // Adicionando o repositório de Paciente
import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
public class PacienteFamiliar {

    private int id;
    private PacienteModels pacienteModels;
    private int pacienteId;
    private FamiliarModels familiarModels;
    private int familiarId;

    // Método para converter a entidade PacienteFamiliar para PacienteFamiliarModels
    public PacienteFamiliarModels toModel() {
        PacienteFamiliarModels pacienteFamiliarModels = new PacienteFamiliarModels();
        pacienteFamiliarModels.setPacienteId(this.pacienteId);
        pacienteFamiliarModels.setFamiliarId(this.familiarId);
        return pacienteFamiliarModels;
    }

}

