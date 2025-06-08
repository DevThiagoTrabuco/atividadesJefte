package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.EnderecoEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.enums.Funcao;
import com.senai.Geriatricare.models.commons.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioModel {
    private int id;
    private String nome;
    private CPF cpf;
    private RG rg;
    private LocalDate dataNascimento;
    private Email email;
    private Senha senha;
    private Telefone telefone;
    private EnderecoModel endereco;
    private Funcao funcao;
    private int clienteId;

    public FuncionarioEntity toEntity(ClienteEntity cliente) {
        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setId(this.id);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        funcionario.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        funcionario.setSenha(this.senha.validaSenha() ? this.senha.getSenha() : null);
        funcionario.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        funcionario.setEndereco(this.endereco.toEntity());
        funcionario.setFuncao(this.funcao);
        funcionario.setCliente(cliente);

        return funcionario;
    }
}
