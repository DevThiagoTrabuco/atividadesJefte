package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.models.commons.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private int id;
    private String nome;
    private Email email;
    private Telefone telefone;
    private CNPJ cnpj;
    private EnderecoModel endereco;
    private int adminId;

    public ClienteEntity toEntity(AdminEntity admin){
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        cliente.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        cliente.setCnpj(this.cnpj.getCnpj());
        cliente.setEndereco(this.endereco.toEntity());
        cliente.setAdmin(admin);
        return cliente;
    }
}
