package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoBasico implements PlanoInterface{
    private int id;
    private String nome;
    private TipoPlanoEnums tipoPlano;
    int periodoMensalidade;
    private String descricao;
    private double preco;
    private List<String> beneficio;

    @Override
    public String toString() {
        return beneficio != null && !beneficio.isEmpty()
                ? String.join(", ", beneficio)
                : "Nenhum benefício disponível";
    }
}
