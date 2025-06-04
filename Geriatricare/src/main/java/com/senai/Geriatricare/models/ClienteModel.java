package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.entities.ClienteEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cnpj;
    private EnderecoModel endereco;
    private int adminId;

    public ClienteEntity toEntity(AdminEntity admin){
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setSenha(this.senha);
        cliente.setTelefone(this.telefone);
        cliente.setCnpj(this.cnpj);
        cliente.setEndereco(this.endereco.toEntity());
        cliente.setAdmin(admin);

        return cliente;
    }
}
