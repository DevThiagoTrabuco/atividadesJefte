package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import org.springframework.stereotype.Repository;
import com.geriaTeam.geriatricare.models.domain.Funcionario;

@Repository
public class FuncionarioRepositoryImpl implements FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
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
        return funcionarios;
    }

    @Override
    public Funcionario buscarPorCodigo(int codigo) {
        Funcionario Funcionario = funcionarios
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return Funcionario;
    }

    @Override
    public void remover(int codigo) {
        funcionarios.removeIf(l -> l.getId() == codigo);
    }


}
