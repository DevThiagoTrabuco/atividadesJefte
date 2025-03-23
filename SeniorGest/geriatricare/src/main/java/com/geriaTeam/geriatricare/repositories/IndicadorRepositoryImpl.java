package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;


import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.domain.Indicador;

public class IndicadorRepositoryImpl implements IndicadorRepository {
    private List<Indicador> indicadors = new ArrayList<>();

    @Override
    public void adicionar(Indicador indicador) {
        indicadors.add(indicador);
    }

    @Override
    public void atualizar(int codigo, Indicador indicador) {
        Indicador indicadorEmMemoria = this.buscarPorCodigo(codigo);
        indicadorEmMemoria.setId(indicador.getId());
        indicadorEmMemoria.setBatimentos(indicador.getBatimentos());
        indicadorEmMemoria.setOximetria(indicador.getOximetria());
        indicadorEmMemoria.setTemperatura(indicador.getTemperatura());
    }

    @Override
    public List<Indicador> buscar() {
        return indicadors;
    }

    @Override
    public Indicador buscarPorCodigo(int codigo) {
        Indicador indicador = indicadors
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return indicador;
    }

    @Override
    public void remover(int codigo) {
        indicadors.removeIf(l -> l.getId() == codigo);
    }


}



