package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.enums.Funcao;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioModel {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String telefone;
    private Funcao funcao;
    private int clienteId;

    public FuncionarioEntity toEntity(ClienteEntity cliente) {
        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setId(this.id);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf);
        funcionario.setRg(this.rg);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setEmail(this.email);
        funcionario.setSenha(this.senha);
        funcionario.setTelefone(this.telefone);
        funcionario.setFuncao(this.funcao);
        funcionario.setCliente(cliente);

        return funcionario;
    }
}
