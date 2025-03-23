package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.SinaisVitaisApplication;
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

    public SinaisVitais buscarPorCodigo(int codigo) {
        return sinaisvitaisApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(SinaisVitais sinaisvitais) {
        sinaisvitaisApplication.adicionar(sinaisvitais);
    }

    public void atualizar(int codigo, SinaisVitais sinaisvitais) {
        sinaisvitaisApplication.atualizar(codigo, sinaisvitais);
    }

    public void remover(int codigo) {
        sinaisvitaisApplication.remover(codigo);
    }
}
