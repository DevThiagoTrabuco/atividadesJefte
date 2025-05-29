package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FuncaoModels;
import com.geriaTeam.geriatricare.models.FuncionarioModels;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    private int id;
    private String nome;
    private String sobrenome;
    private LocalDateTime dataNascimento;
    private FuncaoModels funcaoModels;
    private CPF cpf;
    private RG rg;
    private CTPS ctps;
    private Telefone telefone;
    private Email email;
    private String senha;

    // Método para converter a entidade Funcionario para FuncionarioModels
    public FuncionarioModels toModel() {
        FuncionarioModels funcionarioModels = new FuncionarioModels();
        funcionarioModels.setId(this.id);
        funcionarioModels.setNome(this.nome);
        funcionarioModels.setSobrenome(this.sobrenome);
        funcionarioModels.setDataNascimento(this.dataNascimento);
        funcionarioModels.setFuncaoModels(this.funcaoModels);
        funcionarioModels.setCpf(this.cpf.toString());
        funcionarioModels.setRg(this.rg.toString());
        funcionarioModels.setCtps(this.ctps.toString());
        funcionarioModels.setTelefone(this.telefone.toString());
        funcionarioModels.setEmail(this.email.toString());
        funcionarioModels.setSenha(this.senha);
        return funcionarioModels;
    }
}
