package com.geriaTeam.geriatricare.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CTPS {
    private String numero;
    private String serie;

    public boolean validarCTPS() {
        return numero != null && numero.matches("\\d{7}") &&
                serie != null && serie.matches("\\d{4}");
    }
}