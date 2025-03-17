package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geriaTeam.geriatricare.Interfaces.SinaisVitaisRepository;
import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

@Repository
public class SinaisVitaisRepositoryImpl implements SinaisVitaisRepository {
    private List<SinaisVitais> sinaisvitaiss = new ArrayList<>();

    @Override
    public void adicionar(SinaisVitais sinaisvitais) {
        sinaisvitaiss.add(sinaisvitais);
    }

    @Override
    public void atualizar(int codigo, SinaisVitais sinaisvitais) {
        SinaisVitais sinaisvitaisEmMemoria = this.buscarPorCodigo(codigo);
        sinaisvitaisEmMemoria.setId(sinaisvitais.getId());
        sinaisvitaisEmMemoria.setBatimentos(sinaisvitais.getBatimentos());
        sinaisvitaisEmMemoria.setOximetria(sinaisvitais.getOximetria());
        sinaisvitaisEmMemoria.setTemperatura(sinaisvitais.getTemperatura());
        sinaisvitaisEmMemoria.setIdPaciente(sinaisvitais.getIdPaciente());
    }

    @Override
    public List<SinaisVitais> buscar() {
        return sinaisvitaiss;
    }

    @Override
    public SinaisVitais buscarPorCodigo(int codigo) {
        SinaisVitais sinaisvitais = sinaisvitaiss
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return sinaisvitais;
    }

    @Override
    public void remover(int codigo) {
        sinaisvitaiss.removeIf(l -> l.getId() == codigo);
    }


}



