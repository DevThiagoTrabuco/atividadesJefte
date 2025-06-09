package com.senai.Geriatricare.models.commons;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {
    private String telefone;

    public boolean validaTelefone() {
        return telefone != null && telefone.matches("\\(?\\d{2}\\)? ?9?\\d{4}-?\\d{4}");
    }
}
