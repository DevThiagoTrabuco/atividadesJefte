package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.AdminModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private int id;
    private String nome;
    private Email email;
    private String senha;

    public AdminModels toModel() {
        AdminModels adminModels = new AdminModels();
        adminModels.setId(this.id);
        adminModels.setNome(this.nome);
        adminModels.setEmail(this.email.toString());
        adminModels.setSenha(this.senha);
        return adminModels;
    }
}
