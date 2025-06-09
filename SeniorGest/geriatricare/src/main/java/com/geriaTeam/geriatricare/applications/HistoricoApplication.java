package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.entities.Historico;
import com.geriaTeam.geriatricare.entities.Login;
import com.geriaTeam.geriatricare.entities.Senha;
import com.geriaTeam.geriatricare.models.HistoricoModels;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoApplication {
    private final HistoricoRepository historicoRepository;

    @Autowired
    public HistoricoApplication(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void adicionarHistorico(HistoricoModels model) {
        Historico historico = new Historico();
        historico.setId(model.getHistoricoId());
        historico.setPaciente(model.getPaciente());
        historico.setOcorrencia(model.getOcorrencia());
        historico.setObservacao(model.getObservacao());
        historico.setDataAlteracao(model.getDataAlteracao());
        historico.setFuncionario(model.getFuncionario());

        historicoRepository.adicionarHistorico(historico.toModel());
    }

    public void atualizarHistorico(HistoricoModels model) {
        HistoricoModels existente = historicoRepository.buscarHistoricoId(model.getHistoricoId());
        if (existente == null) {
            throw new EntityNotFoundException("Histórico não encontrado.");
        }
        historicoRepository.atualizarHistorico(model);
    }

    public void removerHistorico(int codigo) {
        historicoRepository.removerHistorico(codigo);
    }

    public List<HistoricoModels> buscarHistorico() {
        return historicoRepository.buscarHistorico();
    }

    public HistoricoModels buscarHistoricoId(int codigo) {
        HistoricoModels historico = historicoRepository.buscarHistoricoId(codigo);
        if (historico == null) {
            throw new EntityNotFoundException("Histórico não encontrado.");
        }
        return historico;
    }
}
