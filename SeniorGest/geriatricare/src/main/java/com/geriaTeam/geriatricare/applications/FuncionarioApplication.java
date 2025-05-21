package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import com.geriaTeam.geriatricare.models.FuncionarioModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioApplication {
    private FuncionarioRepository funcionarioRepository;


    @Autowired
    public FuncionarioApplication(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void adicionar(FuncionarioModels funcionarioModels){
        this.funcionarioRepository.adicionar(funcionarioModels);
    }

    public void atualizar(FuncionarioModels funcionarioModels){
        this.funcionarioRepository.atualizar(funcionarioModels);
    }

    public void remover(int codigo){
        this.funcionarioRepository.remover(codigo);
    }

    public List<FuncionarioModels> buscar(){
        return this.funcionarioRepository.buscar();
    }

    public FuncionarioModels buscarPorCodigo(int codigo){
        return this.funcionarioRepository.buscarPorCodigo(codigo);
    }
}

