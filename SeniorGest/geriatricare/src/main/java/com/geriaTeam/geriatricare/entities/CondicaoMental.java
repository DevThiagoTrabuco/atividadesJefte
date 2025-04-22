package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import lombok.*;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
@Setter
@AllArgsConstructor
public class CondicaoMental {
    private int id;
    private String nome;
    private String descricao;

    // Método para converter a entidade CondicaoMental para CondicaoMentalModels
    public CondicaoMentalModels toModel() {
        CondicaoMentalModels condicaoMentalModels = new CondicaoMentalModels();
        condicaoMentalModels.setNome(this.nome);
        condicaoMentalModels.setDescricao(this.descricao);
        return condicaoMentalModels;
    }

}
