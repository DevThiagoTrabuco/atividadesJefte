package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FuncaoModels;
import com.geriaTeam.geriatricare.models.FuncionarioModels;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    private int id;
    private String nome;
    private String sobrenome;
    private Login login;
    private Senha senha;
    private Funcao funcao;
    private CPF cpf;
    private RG rg;
    private CTPS ctps;
    private Telefone telefone;
    private Email email;

    // Método para converter a entidade Funcionario para FuncionarioModels
    public FuncionarioModels toModel() {
        FuncionarioModels funcionarioModels = new FuncionarioModels();
        funcionarioModels.setId(this.id);
        funcionarioModels.setNome(this.nome);
        funcionarioModels.setSobrenome(this.sobrenome);
        funcionarioModels.setLogin(this.login);
        funcionarioModels.setSenha(this.senha);
        funcionarioModels.setFuncaoModels(this.funcao.toModel());
        funcionarioModels.setCpf(this.cpf);
        funcionarioModels.setRg(this.rg);
        funcionarioModels.setCtps(this.ctps);
        funcionarioModels.setTelefone(this.telefone);
        funcionarioModels.setEmail(this.email);
        return funcionarioModels;
    }
}
