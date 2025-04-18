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

    public String verificarEstadoSaude() {
        if (this.condicaoMental != null && this.condicaoFisica != null) {
            String estadoMental = this.condicaoMental.getNome();
            String estadoFisico = this.condicaoFisica.getNome();

            if (estadoMental.equals("Estável") && estadoFisico.equals("Estável")) {
                return "Paciente está estável";
            } else if (estadoMental.equals("Crítico") || estadoFisico.equals("Crítico")) {
                return "Paciente está em estado crítico";
            } else {
                return "Paciente está em estado moderado";
            }
        } else {
            return "Informações de condição de saúde não estão completas";
        }
    }


    public void registrarEntrada(LocalDateTime dataEntrada) {
        this.entrada = dataEntrada;
        // Fazer outras ações como notificar responsáveis ou registrar em algum sistema
    }

    public int calcularIdade() {
        LocalDateTime agora = LocalDateTime.now();
        return agora.getYear() - this.nascimento.getYear();
    }

    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos() {
        return this.pacienteMedicamentoModels;
    }

    public void adicionarFamiliar(PacienteFamiliarModels familiar) {
        this.pacienteFamiliarModels.add(familiar);
        // Fazer outras ações necessárias como notificar familiar ou atualizar no banco
    }

    public PlanoModels verificarPlanoSaude() {
        if (this.planoModels != null) {
            return this.planoModels;
        } else {
            return null;  // Ou lançar uma exceção se preferir
        }
    }
}
