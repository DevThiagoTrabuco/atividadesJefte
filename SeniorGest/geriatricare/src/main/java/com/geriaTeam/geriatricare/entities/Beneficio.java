package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.BeneficioModels;
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
public class Beneficio {
    private int id;
    private String descricao;
    private List<PlanoBeneficioModels> planoBeneficioModels;

    public Beneficio toModel(BeneficioModels beneficioModels) {
        return new Beneficio(
                beneficioModels.getId(),
                beneficioModels.getDescricao(),
                beneficioModels.getPlanoBeneficioModels()
        );
    }
}