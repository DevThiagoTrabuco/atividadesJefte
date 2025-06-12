package com.senai.Geriatricare.models.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CNPJ {
    private Pattern CNPJ_PADRAO = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
    private String cnpj;

    @JsonCreator
    public CNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    @JsonValue
    public String getCnpj() {
        return cnpj;
    }

    public boolean validaCNPJ() {
        if (cnpj == null) return false;

        String cnpjNum = cnpj.replaceAll("\\D", "");
        if (cnpjNum.length() != 14) return false;

        if (cnpjNum.chars().distinct().count() == 1) return false;

        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += (cnpjNum.charAt(i) - '0') * pesos1[i];
        }
        int dig1 = soma % 11;
        dig1 = (dig1 < 2) ? 0 : 11 - dig1;

        if (dig1 != (cnpjNum.charAt(12) - '0')) return false;

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += (cnpjNum.charAt(i) - '0') * pesos2[i];
        }
        int dig2 = soma % 11;
        dig2 = (dig2 < 2) ? 0 : 11 - dig2;

        return dig2 == (cnpjNum.charAt(13) - '0');
    }
}
