package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.enums.Parentesco;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FamiliarModel {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;
    private String rg;
    private Parentesco parentesco;
    private int clienteId;
    private EnderecoModel endereco;
    private List<PacienteModel> pacientes;

    public FamiliarEntity toEntity(ClienteEntity cliente) {
        FamiliarEntity familiar = new FamiliarEntity();
        familiar.setId(this.id);
        familiar.setNome(this.nome);
        familiar.setEmail(this.email);
        familiar.setSenha(this.senha);
        familiar.setTelefone(this.telefone);
        familiar.setCpf(this.cpf);
        familiar.setRg(this.rg);
        familiar.setParentesco(this.parentesco);
        familiar.setCliente(cliente);
        familiar.setEndereco(this.endereco.toEntity());

        return familiar;
    }
}
