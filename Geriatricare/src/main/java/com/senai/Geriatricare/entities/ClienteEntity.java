package com.senai.Geriatricare.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

import java.util.List;

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
    @JsonProperty("admin_id")
    private int adminId;
    private List<ContasAPagarModel> contasAPagar;

    public ClienteModel toEntity(AdminModel admin){
        ClienteModel cliente = new ClienteModel();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        cliente.setTelefone(this.telefone.validaTelefone() ? this.telefone.getTelefone() : null);
        cliente.setCnpj(this.cnpj.getCnpj());
        cliente.setEndereco(this.endereco.toEntity());

        if (this.contasAPagar != null) {
            this.contasAPagar.forEach(c -> c.setCliente(cliente));
            cliente.setContasAPagarModel(this.contasAPagar);
        }

        return cliente;
    }
}
