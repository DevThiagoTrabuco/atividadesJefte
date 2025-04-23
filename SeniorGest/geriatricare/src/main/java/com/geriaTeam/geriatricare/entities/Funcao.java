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

    // Método para validar o ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método para validar o nome
    public static boolean validarNome(String nome) {
        return nome != null && !nome.isBlank() && nome.length() <= 100;
    }

    // Método para converter a entidade Funcao para FuncaoModels
    public FuncaoModels toModel() {
        FuncaoModels funcaoModels = new FuncaoModels();
        funcaoModels.setNome(this.nome);
        return funcaoModels;
    }
}