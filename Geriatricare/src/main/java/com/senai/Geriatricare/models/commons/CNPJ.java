package com.senai.Geriatricare.models.commons;

import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CNPJ {
    private Pattern CNPJ_PADRAO =
            Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");

    private String cnpj;

    public boolean validaCNPJ() {
        if (cnpj == null || !CNPJ_PADRAO.matcher(cnpj).matches()) {
            return false;
        }

        cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");

        if (cnpj.chars().distinct().count() == 1) return false; // Ex: 00.000.000/0000-00

        int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;

        for (int i = 0; i < 12; i++) {
            soma += (cnpj.charAt(i) - '0') * pesos[i];
        }

        int primeiroDigito = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
        if (primeiroDigito != cnpj.charAt(12) - '0') return false;

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += (cnpj.charAt(i) - '0') * pesos[i % pesos.length];
        }

        int segundoDigito = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
        return segundoDigito == cnpj.charAt(13) - '0';
    }
}
