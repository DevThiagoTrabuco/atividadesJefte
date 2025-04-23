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
    private String sobrenome;
    private String cpf;
    private String rg;
    private LocalDateTime nascimento;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private CondicaoMentalModels condicaoMental;
    private CondicaoFisicaModels condicaoFisica;
    private List<PacienteMedicamentoModels> pacienteMedicamentoModels;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;
    private PlanoModels planoModels;

    // Método para converter a entidade Paciente para PacienteModels
    public PacienteModels toModel() {
        PacienteModels pacienteModels = new PacienteModels();
        pacienteModels.setId(this.id);
        pacienteModels.setNome(this.nome);
        pacienteModels.setSobrenome(this.sobrenome);
        pacienteModels.setCpf(this.cpf);
        pacienteModels.setRg(this.rg);
        pacienteModels.setNascimento(this.nascimento);
        pacienteModels.setEntrada(this.entrada);
        pacienteModels.setSaida(this.saida);
        pacienteModels.setCondicaoMental(this.condicaoMental);
        pacienteModels.setCondicaoFisica(this.condicaoFisica);
        pacienteModels.setPacienteMedicamentoModels(this.pacienteMedicamentoModels);
        pacienteModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        pacienteModels.setPlanoModels(this.planoModels);
        return pacienteModels;
    }
}