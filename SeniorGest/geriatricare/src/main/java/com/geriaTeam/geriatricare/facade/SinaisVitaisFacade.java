package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SinaisVitaisFacade {
    @Autowired
    private SinaisVitaisApplication sinaisvitaisApplication;

    public List<SinaisVitais> buscar() {
        return sinaisvitaisApplication.buscar();
    }

    public SinaisVitais buscarPorCodigo(UUID codigo) {
        return sinaisvitaisApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(SinaisVitais sinaisvitais) {
        sinaisvitaisApplication.cadastrar(sinaisvitais);
    }

    public void atualizar(UUID codigo, SinaisVitais sinaisvitais) {
        sinaisvitaisApplication.atualizar(codigo, sinaisvitais);
    }

    public void remover(UUID codigo, SinaisVitais sinaisvitais) {
        sinaisvitaisApplication.remover(codigo, sinaisvitais);
    }
}
