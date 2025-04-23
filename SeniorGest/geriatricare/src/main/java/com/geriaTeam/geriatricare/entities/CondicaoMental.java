package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CondicaoMental {
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

    // Método para converter a entidade CondicaoMental para CondicaoMentalModels
    public CondicaoMentalModels toModel() {
        CondicaoMentalModels condicaoMentalModels = new CondicaoMentalModels();
        condicaoMentalModels.setNome(this.nome);
        condicaoMentalModels.setDescricao(this.descricao);
        return condicaoMentalModels;
    }
}