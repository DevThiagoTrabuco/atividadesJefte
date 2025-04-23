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
    private String email;
    private String telefone;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;

    // Método para validar o ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método para validar o nome
    public static boolean validarNome(String nome) {
        return nome != null && !nome.isBlank() && nome.length() <= 100;
    }

    // Método para validar o email
    public static boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.length() <= 100;
    }

    // Método para validar o telefone
    public static boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{10,15}");
    }

    // Método para converter a entidade Familiar para FamiliarModels
    public FamiliarModels toModel() {
        FamiliarModels familiarModels = new FamiliarModels();
        familiarModels.setNome(this.nome);
        familiarModels.setEmail(this.email);
        familiarModels.setTelefone(this.telefone);
        familiarModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        return familiarModels;
    }
}