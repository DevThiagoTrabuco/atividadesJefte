package com.senai.Geriatricare.models.commons;

import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Senha {
    private Pattern SENHA_PADRAO = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private String senha;

    public boolean isSenhaValida() {
        return SENHA_PADRAO.matcher(senha).matches();
    }
}
