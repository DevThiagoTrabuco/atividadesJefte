package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.models.BeneficioModels;
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
    private String tipoPlano;
    private String descricao;
    private double preco;
    private List<String> beneficios;
    private List<PlanoBeneficioModels> planoBeneficioModels;

    public Plano(TipoPlanoEnums tipoPlanoEnums, List<PlanoBeneficioModels> planoBeneficioModels) {
        // Filtra os benefícios associados ao tipo de plano usando os IDs
        List<String> beneficiosFiltrados = planoBeneficioModels.stream()
                .filter(planoBeneficio -> planoBeneficio.getPlanoId() == tipoPlanoEnums.ordinal() + 1) // Verifica o ID do plano
                .map(planoBeneficio -> {
                    BeneficioModels beneficio = new BeneficioModels();
                    beneficio.setId(planoBeneficio.getBeneficioId()); // Define o ID do benefício
                    return beneficio.getDescricao(); // Obtém a descrição do benefício
                })
                .toList();

        switch (tipoPlanoEnums) {
            case PLANO_BASICO:
                this.id = 1;
                this.nome = "Plano Básico";
                this.tipoPlano = "Básico";
                this.descricao = "Plano com benefícios essenciais.";
                this.preco = 100.0;
                this.beneficios = beneficiosFiltrados;
                break;
            case PLANO_INTERMEDIARIO:
                this.id = 2;
                this.nome = "Plano Intermediário";
                this.tipoPlano = "Intermediário";
                this.descricao = "Plano com benefícios intermediários.";
                this.preco = 200.0;
                this.beneficios = beneficiosFiltrados;
                break;
            case PLANO_AVANCADO:
                this.id = 3;
                this.nome = "Plano Premium";
                this.tipoPlano = "Premium";
                this.descricao = "Plano com todos os benefícios disponíveis.";
                this.preco = 300.0;
                this.beneficios = beneficiosFiltrados;
                break;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlanoEnums);
        }
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public List<String> getBeneficios() {
        return this.beneficios;
    }


    public PlanoModels toModel() {
        PlanoModels planoModels = new PlanoModels();
        planoModels.setId(this.id);
        planoModels.setNome(this.nome);
        planoModels.setTipoPlano(this.tipoPlano);
        planoModels.setDescricao(this.descricao);
        planoModels.setPreco(this.preco);
        planoModels.setPlanoBeneficioModels(this.planoBeneficioModels); // Define os benefícios associados
        return planoModels;
    }
}
