package com.senai.Geriatricare.models.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Senha {
    private Pattern SENHA_PADRAO = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    private String senha;

    @JsonCreator
    public Senha(String senha) {
        this.senha = senha;
    }

    @JsonValue
    public String getSenha() {
        return senha.toString();
    }

    public boolean validaSenha() {
        return SENHA_PADRAO.matcher(senha).matches();
    }
}
