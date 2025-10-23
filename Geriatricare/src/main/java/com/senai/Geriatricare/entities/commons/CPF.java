package com.senai.Geriatricare.entities.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CPF {
    private Pattern CPF_PADRAO = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    private String cpf;

    @JsonCreator
    public CPF(String cpf) {
        this.cpf = cpf;
    }

    @JsonValue
    public String getCpf() {
        return cpf;
    }

    public boolean validaCPF() {
        if (cpf == null || !CPF_PADRAO.matcher(cpf).matches()) {
            return false;
        }

        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.chars().distinct().count() == 1) return false; // Ex: 000.000.000-00

        int num = 0;
        for (int i = 0; i < 9; i++) num += (cpf.charAt(i) - '0') * (10 - i);
        int primeiraChecagem = 11 - (num % 11);
        if (primeiraChecagem >= 10) primeiraChecagem = 0;
        if (primeiraChecagem != cpf.charAt(9) - '0') return false;

        num = 0;
        for (int i = 0; i < 10; i++) num += (cpf.charAt(i) - '0') * (11 - i);
        int segundaChecagem = 11 - (num % 11);
        if (segundaChecagem >= 10) segundaChecagem = 0;
        return segundaChecagem == cpf.charAt(10) - '0';
    }
}
