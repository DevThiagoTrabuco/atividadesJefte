package com.geriaTeam.geriatricare.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RG {
    private String numero;
    private String orgaoEmissor;
    private String estado;

    public boolean validarRG() {
        return numero != null && numero.matches("\\d{9}");
    }

    @Override
    public String toString() {
        return numero;
    }
}