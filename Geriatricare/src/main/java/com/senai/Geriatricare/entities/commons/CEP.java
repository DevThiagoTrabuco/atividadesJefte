package com.senai.Geriatricare.entities.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CEP {
    private Pattern CEP_PADRAO = Pattern.compile("\\d{5}-\\d{3}");
    private String cep;

    @JsonCreator
    public CEP(String cep) {
        this.cep = cep;
    }

    @JsonValue
    public String getCep() {
        return cep;
    }

    public boolean validaCEP() {
        if (cep == null || !CEP_PADRAO.matcher(cep).matches()) {
            return false;
        }
        cep = cep.replace("-", "");
        if (cep.chars().distinct().count() == 1) return false;
        return true;
    }
}