package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CondicaoFisica {
    private int id;
    private String nome;
    private String descricao;


    // Método para validar o ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método para validar o nome
    public static boolean validarNome(String nome) {
        return nome != null && !nome.isBlank() && nome.length() <= 100;
    }

    // Método para validar a descrição
    public static boolean validarDescricao(String descricao) {
        return descricao != null && !descricao.isBlank() && descricao.length() <= 255;
    }

    // Método para converter a entidade CondicaoFisica para CondicaoFisicaModels
    public CondicaoFisicaModels toModel() {
        CondicaoFisicaModels condicaoFisicaModels = new CondicaoFisicaModels();
        condicaoFisicaModels.setNome(this.nome);
        condicaoFisicaModels.setDescricao(this.descricao);
        return condicaoFisicaModels;
    }
}