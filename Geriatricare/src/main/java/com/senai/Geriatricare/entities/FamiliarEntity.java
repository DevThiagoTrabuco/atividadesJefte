package com.senai.Geriatricare.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.enums.Parentesco;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamiliarEntity {
    private int id;
    private String nome;
    private Email email;
    private Telefone telefone;
    private CPF cpf;
    private RG rg;
    private Parentesco parentesco;
    private int clienteId;
    private EnderecoEntity endereco;
    private List<PacienteEntity> pacientes;

    public FamiliarModel toModel(ClienteModel cliente) {
        FamiliarModel familiar = new FamiliarModel();
        familiar.setId(this.id);
        familiar.setNome(this.nome);
        familiar.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        familiar.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        familiar.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        familiar.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        familiar.setParentesco(this.parentesco);
        familiar.setCliente(cliente);
        familiar.setEndereco(this.endereco.toModel());

        return familiar;
    }
}
