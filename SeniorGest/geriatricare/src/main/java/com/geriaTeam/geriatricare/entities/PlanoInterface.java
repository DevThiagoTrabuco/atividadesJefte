package com.geriaTeam.geriatricare.entities;


import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.models.PlanoModels;

public interface PlanoInterface {
    int getId();

    void setId(int id);

    Strings getNome();

    void setNome(String nome);

    int getPeriodoMensalidade();

    void setPeriodoMensalidade(int periodoMensalidade);

    TipoPlanoEnums getTipoPlano();

    void setTipoPlano(TipoPlanoEnums tipoPlano);

    Strings getDescricao();

    void setDescricao(String descricao);

    double getPreco();

    void setPreco(double preco);

    Strings getBeneficio();

    void setBeneficio(String beneficio);

    PlanoModels toModel();
}