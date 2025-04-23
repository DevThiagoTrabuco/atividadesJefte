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

    // Método para converter a entidade CondicaoFisica para CondicaoFisicaModels
    public CondicaoFisicaModels toModel() {
        CondicaoFisicaModels condicaoFisicaModels = new CondicaoFisicaModels();
        condicaoFisicaModels.setNome(this.nome);
        condicaoFisicaModels.setDescricao(this.descricao);
        return condicaoFisicaModels;
    }
}