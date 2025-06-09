package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteMedicamentoRepository;
import com.geriaTeam.geriatricare.models.domain.PacienteMedicamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteMedicamentoApplication {
    private PacienteMedicamentoRepository pacienteMedicamentoRepository;

    public void adicionar(PacienteMedicamento pacienteMedicamento){
        this.pacienteMedicamentoRepository.adicionar(pacienteMedicamento);
    }

    public void atualizar(PacienteMedicamento pacienteMedicamento){
        this.pacienteMedicamentoRepository.atualizar(pacienteMedicamento);
    }

    public void remover(int codigo){
        this.pacienteMedicamentoRepository.remover(codigo);
    }

    public List<PacienteMedicamento> buscar(){
        return this.pacienteMedicamentoRepository.buscar();
    }

    public PacienteMedicamento buscarPorCodigo(int codigo){
        return this.pacienteMedicamentoRepository.buscarPorCodigo(codigo);
    }
}
