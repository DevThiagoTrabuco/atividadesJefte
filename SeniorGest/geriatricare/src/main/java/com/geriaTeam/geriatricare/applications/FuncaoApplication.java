package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoApplication {
    private final FuncaoRepository funcaoRepository;

    @Autowired
    public FuncaoApplication(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public void adicionarFuncao(FuncaoModels funcao) {

        funcaoRepository.adicionarFuncao(funcao);
    }

    public void removerFuncao(int id) {
        FuncaoModels funcao = funcaoRepository.buscarFuncaoId(id);
        if (funcao != null) {
            funcaoRepository.removerFuncao(id);
        } else {
            throw new EntityNotFoundException("Função não encontrada.");
        }
    }

    public FuncaoModels buscarFuncao(int id) {
        FuncaoModels funcao = funcaoRepository.buscarFuncaoId(id);
        if (funcao == null) {
            throw new EntityNotFoundException("Função não encontrada.");
        }
        return funcao;
    }

    public void atualizarFuncao(FuncaoModels funcaoAtualizada) {
        FuncaoModels funcaoExistente = funcaoRepository.buscarFuncaoId(funcaoAtualizada.getId());
        if (funcaoExistente == null) {
            throw new EntityNotFoundException("Função não encontrada.");
        }

        if (funcaoAtualizada.getNome() != null && !funcaoAtualizada.getNome().isEmpty()) {
            funcaoExistente.setNome(funcaoAtualizada.getNome());
        }

        funcaoRepository.atualizarFuncao(funcaoExistente);
    }

    public List<FuncaoModels> buscarTodasFuncoes() {
        return funcaoRepository.buscarFuncao();
    }
}