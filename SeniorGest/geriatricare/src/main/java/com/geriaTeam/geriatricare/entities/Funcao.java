package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FuncaoModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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