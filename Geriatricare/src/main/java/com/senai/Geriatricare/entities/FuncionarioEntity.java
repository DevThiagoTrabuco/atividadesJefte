package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.StatusFuncionario;
import com.senai.Geriatricare.enums.UnidadeFederativa;
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
    private String registro;
    private Telefone telefone;
    private EnderecoEntity endereco;
    private Funcao funcao;
    private StatusFuncionario statusFuncionario = StatusFuncionario.ATIVO;
    private LocalDate dataAdmissao;
    private int clienteId;

    public FuncionarioModel toModel(ClienteModel cliente) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setId(this.id);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        funcionario.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        funcionario.setRegistro(this.registro);
        funcionario.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        funcionario.setEndereco(this.endereco.toModel());
        funcionario.setFuncao(this.funcao);
        funcionario.setStatusFuncionario(this.statusFuncionario);
        funcionario.setDataAdmissao(this.dataAdmissao);
        funcionario.setCliente(cliente);

        return funcionario;
    }
}
