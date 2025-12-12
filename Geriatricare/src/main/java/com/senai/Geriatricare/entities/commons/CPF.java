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
        if (cpf == null) return false;

        // Use a local variable for validation to avoid modifying the stored 'cpf' field
        String cpfNum = cpf.replaceAll("[^0-9]", "");

        if (cpfNum.length() != 11) return false;

        if (cpfNum.chars().distinct().count() == 1) return false; // Ex: 00000000000

        int num = 0;
        for (int i = 0; i < 9; i++) num += (cpfNum.charAt(i) - '0') * (10 - i);
        int primeiraChecagem = 11 - (num % 11);
        if (primeiraChecagem >= 10) primeiraChecagem = 0;
        if (primeiraChecagem != cpfNum.charAt(9) - '0') return false;

        num = 0;
        for (int i = 0; i < 10; i++) num += (cpfNum.charAt(i) - '0') * (11 - i);
        int segundaChecagem = 11 - (num % 11);
        if (segundaChecagem >= 10) segundaChecagem = 0;
        return segundaChecagem == cpfNum.charAt(10) - '0';
    }
}
