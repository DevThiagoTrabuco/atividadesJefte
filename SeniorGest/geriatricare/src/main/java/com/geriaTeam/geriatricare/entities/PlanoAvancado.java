package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.models.PlanoBeneficioModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoAvancado implements PlanoInterface {
    private int id;
    private String nome;
    private TipoPlanoEnums tipoPlano;
    private String descricao;
    private double preco;
    private List<String> beneficio;
}
