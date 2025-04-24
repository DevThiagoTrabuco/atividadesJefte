package com.geriaTeam.geriatricare.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
    private String numero;

    public boolean validarTelefone() {
        return numero != null && numero.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}");
    }
}