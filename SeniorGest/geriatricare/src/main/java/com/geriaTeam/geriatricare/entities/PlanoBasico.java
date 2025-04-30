package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.models.PlanoModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoBasico implements PlanoInterface{
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

    public static List<String> obterBeneficiosPlanoBasico() {
        List<String> beneficios = new ArrayList<>();
        beneficios.add("Consulta médica básica");
        beneficios.add("Exames laboratoriais simples");
        beneficios.add("Atendimento de urgência");
        beneficios.add("Descontos em farmácias");
        beneficios.add("Acesso a rede credenciada básica");
        beneficios.add("Atendimento telefônico 24h");
        beneficios.add("Orientação nutricional básica");
        beneficios.add("Acompanhamento de pressão arterial");
        beneficios.add("Vacinas básicas");
        beneficios.add("Check-up anual básico");

        // Adicionando mais 5 benefícios
        beneficios.add("Acesso a palestras de saúde");
        beneficios.add("Descontos em academias");
        beneficios.add("Acompanhamento psicológico inicial");
        beneficios.add("Plano odontológico básico");
        beneficios.add("Atendimento domiciliar emergencial");

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
