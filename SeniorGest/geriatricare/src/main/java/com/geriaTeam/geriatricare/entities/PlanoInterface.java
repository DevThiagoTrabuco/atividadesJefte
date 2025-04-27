package com.geriaTeam.geriatricare.entities;

import java.util.List;

public interface PlanoInterface {
    String getNome();
    String getDescricao();
    double getPreco();
    void setPreco(double preco);
    List<String> getBeneficios();
}