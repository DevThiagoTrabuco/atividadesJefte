package com.geriaTeam.geriatricare.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Senha {
    private String senha;

    public boolean validarSenha() {
        return senha != null && senha.length() >= 8 && senha.matches(".*[a-zA-Z].*") && senha.matches(".*\\d.*");
    }
}
