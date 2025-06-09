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
    private CPF cpf;
    private RG rg;
    private Email email;
    private Telefone telefone;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;

    // Método para converter a entidade Familiar para FamiliarModels
    public FamiliarModels toModel() {
        FamiliarModels familiarModels = new FamiliarModels();
        familiarModels.setId(this.id);
        familiarModels.setNome(this.nome);
        familiarModels.setSobrenome(this.sobrenome);
        familiarModels.setCpf(this.cpf != null ? this.cpf.getNumero() : null);
        familiarModels.setRg(this.rg != null ? this.rg.getNumero() : null);
        familiarModels.setEmail(this.email != null ? this.email.getEndereco() : null);
        familiarModels.setTelefone(this.telefone != null ? this.telefone.getNumero() : null);
        familiarModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        return familiarModels;
    }
}