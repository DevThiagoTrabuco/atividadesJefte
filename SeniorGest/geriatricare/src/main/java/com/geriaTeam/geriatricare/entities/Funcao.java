package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Funcao {
    private int id;
    private String nome;

    // Método para converter a entidade Funcao para FuncaoModels
    public FuncaoModels toModel() {
        FuncaoModels funcaoModels = new FuncaoModels();
        funcaoModels.setNome(this.nome);
        return funcaoModels;
    }

}
