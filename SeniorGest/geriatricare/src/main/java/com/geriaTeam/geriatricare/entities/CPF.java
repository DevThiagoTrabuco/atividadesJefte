package com.geriaTeam.geriatricare.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CPF {
    private String numero;

    public boolean validarCPF() {
        if (numero == null || !numero.matches("\\d{11}")) {
            return false;
        }

        int[] pesos1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(numero.charAt(i));
            soma1 += digito * pesos1[i];
            soma2 += digito * pesos2[i];
        }

        int primeiroDigito = (soma1 % 11 < 2) ? 0 : 11 - (soma1 % 11);
        soma2 += primeiroDigito * pesos2[9];
        int segundoDigito = (soma2 % 11 < 2) ? 0 : 11 - (soma2 % 11);

        return numero.equals(numero.substring(0, 9) + primeiroDigito + segundoDigito);
    }

    @Override
    public String toString() {
        return numero;
    }
}