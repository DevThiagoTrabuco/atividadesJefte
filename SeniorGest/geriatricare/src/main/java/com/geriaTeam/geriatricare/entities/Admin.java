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
    private Login login;
    private Senha senha;

    // Método para converter a entidade Admin para AdminModels
    public AdminModels toModel() {
        AdminModels adminModels = new AdminModels();
        adminModels.setId(this.id);
        adminModels.setNome(this.nome);
        adminModels.setLogin(this.login != null ? this.login.toString() : null);
        adminModels.setSenha(this.senha != null ? this.senha.toString() : null);
        return adminModels;
    }
}
