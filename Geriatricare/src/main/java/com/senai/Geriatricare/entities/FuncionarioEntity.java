package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.enums.Funcao;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioEntity {
    private int id;
    private String nome;
    private CPF cpf;
    private RG rg;
    private LocalDate dataNascimento;
    private Email email;
    private Telefone telefone;
    private EnderecoEntity endereco;
    private Funcao funcao;
    private int clienteId;

    public FuncionarioModel toEntity(ClienteModel cliente) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setId(this.id);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        funcionario.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        funcionario.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        funcionario.setEndereco(this.endereco.toEntity());
        funcionario.setFuncao(this.funcao);
        funcionario.setCliente(cliente);

        return funcionario;
    }
}
