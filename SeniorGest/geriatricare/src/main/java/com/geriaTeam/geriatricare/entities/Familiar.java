package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Familiar {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;

    // Método para converter a entidade Familiar para FamiliarModels
    public FamiliarModels toModel() {
        FamiliarModels familiarModels = new FamiliarModels();
        familiarModels.setNome(this.nome);
        familiarModels.setEmail(this.email);
        familiarModels.setTelefone(this.telefone);
        familiarModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        return familiarModels;
    }

}
