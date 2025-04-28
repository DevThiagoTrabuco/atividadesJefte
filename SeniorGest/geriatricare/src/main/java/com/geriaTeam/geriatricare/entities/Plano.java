package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.models.PlanoBeneficioModels;
import com.geriaTeam.geriatricare.models.PlanoModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plano implements PlanoInterface {
    private int id;
    private String nome;
    private TipoPlanoEnums tipoPlano;
    private String descricao;
    private double preco;
    private PlanoBeneficioModels planoBeneficio;

    public Plano(TipoPlanoEnums tipoPlanoEnums) {
        switch (tipoPlanoEnums) {
            case PLANO_BASICO:
                this.nome = "Plano Básico";
                this.tipoPlano = TipoPlanoEnums.PLANO_BASICO;
                break;
            case PLANO_INTERMEDIARIO:
                this.nome = "Plano Intermediário";
                this.tipoPlano = TipoPlanoEnums.PLANO_INTERMEDIARIO;
                break;
            case PLANO_AVANCADO:
                this.nome = "Plano Premium";
                this.tipoPlano = TipoPlanoEnums.PLANO_AVANCADO;
                break;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlanoEnums);
        }
    }
    public PlanoModels toModel() {
        PlanoModels planoModels = new PlanoModels();
        planoModels.setId(this.id);
        planoModels.setNome(this.nome);
        planoModels.setTipoPlano(String.valueOf(this.tipoPlano));
        planoModels.setDescricao(this.descricao);
        planoModels.setPreco(this.preco);
        planoModels.setPlanoBeneficioModels((List<PlanoBeneficioModels>) this.planoBeneficio);
        return planoModels;
    }
}
