package com.senai.Geriatricare.entities.commons;

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
        if (rg == null) return false;

        String rgNum = rg.replaceAll("[^0-9]", "");

        if (rgNum.length() != 9) return false;

        if (rgNum.chars().distinct().count() == 1) return false;

        int num = 0;
        for (int i = 0; i < 8; i++) num += (rgNum.charAt(i) - '0') * (i + 2);
        int checagem = num % 11;
        if (checagem == 0) checagem = 11;
        checagem = 11 - checagem;

        return checagem == (rgNum.charAt(8) - '0');
    }
}
