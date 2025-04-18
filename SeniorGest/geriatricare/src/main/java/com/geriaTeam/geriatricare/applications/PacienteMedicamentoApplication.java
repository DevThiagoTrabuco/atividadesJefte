package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteMedicamentoRepository;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteMedicamentoApplication {
    private PacienteMedicamentoRepository pacienteMedicamentoRepository;

    public void adicionar(PacienteMedicamentoModels pacienteMedicamentoModels){
        this.pacienteMedicamentoRepository.adicionar(pacienteMedicamentoModels);
    }

    public void atualizar(PacienteMedicamentoModels pacienteMedicamentoModels){
        this.pacienteMedicamentoRepository.atualizar(pacienteMedicamentoModels);
    }

    public void remover(int codigo){
        this.pacienteMedicamentoRepository.remover(codigo);
    }

    public List<PacienteMedicamentoModels> buscar(){
        return this.pacienteMedicamentoRepository.buscar();
    }

    public PacienteMedicamentoModels buscarPorCodigo(int codigo){
        return this.pacienteMedicamentoRepository.buscarPorCodigo(codigo);
    }
}
