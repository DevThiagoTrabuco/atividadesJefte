package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
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
public class PlanoAvancado implements PlanoInterface {
    private int id;
    private Strings nome;
    private int periodoMensalidade;
    private TipoPlanoEnums tipoPlano;
    private Strings descricao;
    private double preco;
    private Strings beneficio;

    @Override
    public void setNome(String nome) {
        this.nome.setString(nome);
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao.setString(descricao);
    }

    @Override
    public void setBeneficio(String beneficio) {
        this.beneficio.setString(beneficio);
    }

    public static List<String> obterBeneficiosPlanoAvancado() {
        PlanoIntermediario planoIntermediario = new PlanoIntermediario();
        List<String> beneficios = planoIntermediario.obterBeneficiosPlanoIntermediario();

        // Adicionando mais 5 benefícios exclusivos do plano avançado
        beneficios.add("Internação em apartamento");
        beneficios.add("Cobertura internacional");
        beneficios.add("Acompanhamento médico VIP");
        beneficios.add("Plano odontológico avançado");
        beneficios.add("Transporte aéreo para emergências");

        return beneficios;
    }

    public PlanoModels toModel() {
        PlanoModels planoModels = new PlanoModels();
        planoModels.setId(this.id);
        planoModels.setNome(this.nome.getString());
        planoModels.setTipoPlano(this.tipoPlano != null ? this.tipoPlano.name() : null);
        planoModels.setPeriodoMensalidade(this.periodoMensalidade);
        planoModels.setDescricao(this.descricao.getString());
        planoModels.setPreco(this.preco);
        planoModels.setBeneficio(this.beneficio != null ? String.join(", ", this.beneficio.getString()) : null);
        return planoModels;
    }
}
