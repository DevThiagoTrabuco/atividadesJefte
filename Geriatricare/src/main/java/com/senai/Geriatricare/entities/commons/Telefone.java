package com.senai.Geriatricare.entities.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Telefone {
    private String telefone;

    @JsonCreator
    public Telefone(String telefone) {this.telefone = telefone;}

    @JsonValue
    public String getTelefone() {return telefone;}

    public boolean validaTelefone() {
        return telefone != null && telefone.matches("\\(?\\d{2}\\)? ?9?\\d{4}-?\\d{4}");
    }
}
