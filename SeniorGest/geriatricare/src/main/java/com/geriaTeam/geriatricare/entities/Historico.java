package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.HistoricoModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Historico {
    private int id;
    private LocalDateTime dataAlteracao;
    private Paciente paciente;
    private Funcionario funcionario;
    private String ocorrencia;
    private String observacao;

    // Método para converter a entidade Historico para HistoricoModels
    public HistoricoModels toModel() {
        HistoricoModels historicoModels = new HistoricoModels();
        historicoModels.setHistoricoId(this.id);
        historicoModels.setDataAlteracao(this.dataAlteracao);
        historicoModels.setPaciente(this.paciente != null ? this.paciente : null);
        historicoModels.setFuncionario(this.funcionario != null ? this.funcionario : null);
        historicoModels.setOcorrencia(this.ocorrencia);
        historicoModels.setObservacao(this.observacao);
        return historicoModels;
    }
}
