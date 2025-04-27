package com.geriaTeam.geriatricare.entities;

import java.util.List;

public class PlanoBasico implements PlanoInterface{
    @Override
    public String getNome() {
        return "";
    }

    @Override
    public String getDescricao() {
        return "";
    }

    @Override
    public double getPreco() {
        return 0;
    }

    @Override
    public void setPreco(double preco) {

    }

    @Override
    public List<String> getBeneficios() {
        return List.of();
    }
}
