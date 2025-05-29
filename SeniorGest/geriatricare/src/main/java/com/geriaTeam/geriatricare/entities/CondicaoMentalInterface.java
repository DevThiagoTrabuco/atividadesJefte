package com.geriaTeam.geriatricare.entities;

import java.util.List;

public interface CondicaoMentalInterface {
    String getDescricao();
    String getGravidade();
    boolean isEstavel();
    void setEstavel(boolean estavel);
    void registrarAcompanhamento(String observacao);
    List<String> getHistoricoAcompanhamento();
}