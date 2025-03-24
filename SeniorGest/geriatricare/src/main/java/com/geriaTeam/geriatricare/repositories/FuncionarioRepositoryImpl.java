package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import com.geriaTeam.geriatricare.models.domain.Funcionario;


public class FuncionarioRepositoryImpl implements FuncionarioRepository {
    private List<Funcionario> Funcionarios = new ArrayList<>();

    @Override
    public void adicionar(Funcionario funcionario) {
        Funcionarios.add(funcionario);
    }

    @Override
    public void atualizar(int codigo, Funcionario Funcionario) {
        Funcionario funcionarioEmMemoria = this.buscarPorCodigo(codigo);
        funcionarioEmMemoria.setId(Funcionario.getId());
        funcionarioEmMemoria.setNome(Funcionario.getNome());
        funcionarioEmMemoria.setEmail(Funcionario.getEmail());
        funcionarioEmMemoria.setTelefone(Funcionario.getTelefone());
        funcionarioEmMemoria.setNascimento(Funcionario.getNascimento());
    }

    @Override
    public List<Funcionario> buscar() {
        return Funcionarios;
    }

    @Override
    public Funcionario buscarPorCodigo(int codigo) {
        Funcionario Funcionario = Funcionarios
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return Funcionario;
    }

    @Override
    public void remover(int codigo) {
        Funcionarios.removeIf(l -> l.getId() == codigo);
    }


}
