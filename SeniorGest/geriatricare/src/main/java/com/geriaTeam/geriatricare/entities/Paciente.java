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
