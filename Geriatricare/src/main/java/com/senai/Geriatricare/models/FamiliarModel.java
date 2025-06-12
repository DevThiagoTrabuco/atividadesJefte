package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.enums.Parentesco;
import com.senai.Geriatricare.models.commons.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamiliarModel {
    private int id;
    private String nome;
    private Email email;
    private Telefone telefone;
    private CPF cpf;
    private RG rg;
    private Parentesco parentesco;
    private int clienteId;
    private EnderecoModel endereco;
    private List<PacienteModel> pacientes;

    public FamiliarEntity toEntity(ClienteEntity cliente) {
        FamiliarEntity familiar = new FamiliarEntity();
        familiar.setId(this.id);
        familiar.setNome(this.nome);
        familiar.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        familiar.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        familiar.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        familiar.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        familiar.setParentesco(this.parentesco);
        familiar.setCliente(cliente);
        familiar.setEndereco(this.endereco.toEntity());

        return familiar;
    }
}
