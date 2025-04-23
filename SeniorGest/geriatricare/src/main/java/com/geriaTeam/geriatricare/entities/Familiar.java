package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Familiar {
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;

    // Método para converter a entidade Familiar para FamiliarModels
    public FamiliarModels toModel() {
        FamiliarModels familiarModels = new FamiliarModels();
        familiarModels.setId(this.id);
        familiarModels.setNome(this.nome);
        familiarModels.setSobrenome(this.sobrenome);
        familiarModels.setCpf(this.cpf);
        familiarModels.setRg(this.rg);
        familiarModels.setEmail(this.email);
        familiarModels.setTelefone(this.telefone);
        familiarModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        return familiarModels;
    }
}