package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    private int id;
    private String nome;
    private Email email;
    private Telefone telefone;
    private CNPJ cnpj;
    private EnderecoEntity endereco;
    private int adminId;

    public ClienteModelModel toEntity(AdminModel admin){
        ClienteModelModel cliente = new ClienteModelModel();
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
