package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Funcionario;
import com.geriaTeam.geriatricare.repositories.FuncionarioRepositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioApplication {
    private FuncionarioRepositoryImpl funcionarioRepository;


    @Autowired
    public FuncionarioApplication(FuncionarioRepositoryImpl funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void adicionar(Funcionario funcionario){
        this.funcionarioRepository.adicionar(funcionario);
    }

    public void atualizar(int codigo, Funcionario funcionario){
        this.funcionarioRepository.atualizar(codigo, funcionario);
    }

    public void remover(int codigo){
        this.funcionarioRepository.remover(codigo);
    }

    public List<Funcionario> buscar(){
        return this.funcionarioRepository.buscar();
    }

    public Funcionario buscarPorCodigo(int codigo){
        return this.funcionarioRepository.buscarPorCodigo(codigo);
    }
}

