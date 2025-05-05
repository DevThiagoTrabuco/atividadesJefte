package com.geriaTeam.geriatricare.entities;


import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.models.PlanoModels;

public interface PlanoInterface {
    int getId();

    void setId(int id);

    String getNome();

    void setNome(String nome);

    int getPeriodoMensalidade();

    void setPeriodoMensalidade(int periodoMensalidade);

    TipoPlanoEnums getTipoPlano();

    void setTipoPlano(TipoPlanoEnums tipoPlano);

    String getDescricao();

    void setDescricao(String descricao);

    double getPreco();

    void setPreco(double preco);

    String getBeneficio();

    void setBeneficio(String beneficio);

    PlanoModels toModel();
}