package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

    // 4. Função para remover uma Condição Física pelo ID


    // 5. Função para atualizar uma Condição Física

}
