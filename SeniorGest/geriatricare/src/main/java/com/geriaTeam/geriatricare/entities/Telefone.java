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
        return numero != null && numero.matches("\\d{10,11}");
    }

    @Override
    public String toString() {
        return numero;
    }
}