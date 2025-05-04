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
public class PlanoIntermediario implements PlanoInterface{
    private int id;
    private String nome;
    private int periodoMensalidade;
    private TipoPlanoEnums tipoPlano;
    private String descricao;
    private double preco ;
    private String beneficio;


    public static List<String> obterBeneficiosPlanoIntermediario() {
        PlanoBasico planoBasico = new PlanoBasico();

        List<String> beneficios = planoBasico.obterBeneficiosPlanoBasico();

        // Adicionando mais 5 benefícios exclusivos do plano intermediário
        beneficios.add("Consultas com especialistas");
        beneficios.add("Exames de imagem avançados");
        beneficios.add("Internação em enfermaria");
        beneficios.add("Acompanhamento fisioterapêutico");
        beneficios.add("Cobertura para medicamentos específicos");

        return beneficios;
    }

    public PlanoModels toModel() {
        PlanoModels planoModels = new PlanoModels();
        planoModels.setId(this.id);
        planoModels.setNome(this.nome);
        planoModels.setTipoPlano(this.tipoPlano != null ? this.tipoPlano.name() : null);
        planoModels.setPeriodoMensalidade(this.periodoMensalidade);
        planoModels.setDescricao(this.descricao);
        planoModels.setPreco(this.preco);
        planoModels.setBeneficio(this.beneficio != null ? String.join(", ", this.beneficio) : null);
        return planoModels;
    }

}
