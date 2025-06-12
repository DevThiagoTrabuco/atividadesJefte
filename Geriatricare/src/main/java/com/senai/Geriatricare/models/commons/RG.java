package com.senai.Geriatricare.models.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RG {
    private Pattern RG_PADRAO = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}");
    private String rg;

    @JsonCreator
    public RG(String rg) {
        this.rg = rg;
    }

    @JsonValue
    public String getRg() {
        return rg;
    }

    public boolean validaRG() {
        if (rg == null || !RG_PADRAO.matcher(rg).matches()) {
            return false;
        }

        rg = rg.replace(".", "").replace("-", "");

        if (rg.chars().distinct().count() == 1) return false; // Ex: 00.000.000-0

        int num = 0;
        for (int i = 0; i < 8; i++) num += (rg.charAt(i) - '0') * (9 - i);
        int checagem = num % 11;
        if (checagem == 10) checagem = 'X';
        else checagem += '0';

        return checagem == rg.charAt(8);
    }
}
