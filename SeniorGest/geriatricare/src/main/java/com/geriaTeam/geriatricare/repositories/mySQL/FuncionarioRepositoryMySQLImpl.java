package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import com.geriaTeam.geriatricare.models.domain.Funcionario;
import com.geriaTeam.geriatricare.repositories.jpa.FuncionarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioRepositoryMySQLImpl implements FuncionarioRepository {
    private final FuncionarioJPA funcionarioJPA;

    @Autowired
    public FuncionarioRepositoryMySQLImpl(FuncionarioJPA funcionarioJPA) {
        this.funcionarioJPA = funcionarioJPA;
    }

    @Override
    public Funcionario buscarPorCodigo(int codigo) {
        return this.funcionarioJPA.findById(codigo).get();
    }

    @Override
    public List<Funcionario> buscar() {
        return this.funcionarioJPA.findAll();
    }

    @Override
    public void adicionar(Funcionario funcionario) {
        this.funcionarioJPA.save(funcionario);
    }

    @Override
    public void remover(int codigo) {
        this.funcionarioJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Funcionario funcionario) {
        Funcionario funcionarioDB = this.funcionarioJPA.findById(codigo).get();

        funcionarioDB.setNome(funcionario.getNome());
        funcionarioDB.setEmail(funcionario.getEmail());
        funcionarioDB.setTelefone(funcionario.getTelefone());
        funcionarioDB.setNascimento(funcionario.getNascimento());
        funcionarioDB.setFuncao(funcionario.getFuncao());

        this.funcionarioJPA.save(funcionarioDB);
    }
}
