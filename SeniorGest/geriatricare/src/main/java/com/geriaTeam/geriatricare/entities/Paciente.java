package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private int id;
    private String nome;
    private LocalDateTime nascimento;
    private LocalDateTime entrada;
    private CondicaoMentalModels condicaoMental;
    private CondicaoFisicaModels condicaoFisica;
    private List<PacienteMedicamentoModels> pacienteMedicamentoModels;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;
    private PlanoModels planoModels;

    // Método para validar o ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método para validar o nome
    public static boolean validarNome(String nome) {
        return nome != null && !nome.isBlank() && nome.length() <= 100;
    }

    // Método para validar a data de nascimento
    public static boolean validarNascimento(LocalDateTime nascimento) {
        return nascimento != null && nascimento.isBefore(LocalDateTime.now());
    }

    // Método para validar a data de entrada
    public static boolean validarEntrada(LocalDateTime entrada) {
        return entrada != null && entrada.isBefore(LocalDateTime.now());
    }

    // Método para converter a entidade Paciente para PacienteModels
    public PacienteModels toModel() {
        PacienteModels pacienteModels = new PacienteModels();
        pacienteModels.setNome(this.nome);
        pacienteModels.setNascimento(this.nascimento);
        pacienteModels.setEntrada(this.entrada);
        pacienteModels.setCondicaoMental(this.condicaoMental);
        pacienteModels.setCondicaoFisica(this.condicaoFisica);
        pacienteModels.setPacienteMedicamentoModels(this.pacienteMedicamentoModels);
        pacienteModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        pacienteModels.setPlanoModels(this.planoModels);
        return pacienteModels;
    }
}