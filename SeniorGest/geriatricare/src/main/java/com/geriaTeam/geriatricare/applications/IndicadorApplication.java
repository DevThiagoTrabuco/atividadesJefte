package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.entities.Indicador;
import com.geriaTeam.geriatricare.models.IndicadorModels;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndicadorApplication {
    @Autowired
    private IndicadorRepository indicadorRepository;


    public void adicionarIndicador(IndicadorModels model) {
        Indicador indicador = new Indicador();
        indicador.setId(model.getId());
        indicador.setBatimentos(model.getBatimentos());
        indicador.setOximetria(model.getOximetria());
        indicador.setTemperatura(model.getTemperatura());
        indicador.setPaciente(model.getPaciente());

        indicadorRepository.adicionarIndicador(indicador.toModel());
    }

    public void atualizarIndicador(IndicadorModels model) {
        IndicadorModels existente = indicadorRepository.buscarIndicadorId(model.getId());
        if (existente == null) {
            throw new EntityNotFoundException("Indicador não encontrado.");
        }
        indicadorRepository.atualizarIndicador(model);
    }

    public void removerIndicador(int codigo) {
        IndicadorModels existente = indicadorRepository.buscarIndicadorId(codigo);
        if (existente == null) {
            throw new EntityNotFoundException("Indicador não encontrado.");
        }
        indicadorRepository.removerIndicador(codigo);
    }

    public List<IndicadorModels> buscarTodosIndicador() {
        return indicadorRepository.buscarIndicador();
    }

    public IndicadorModels buscarIndicadorId(int codigo) {
        IndicadorModels indicador = indicadorRepository.buscarIndicadorId(codigo);
        if (indicador == null) {
            throw new EntityNotFoundException("Indicador não encontrado.");
        }
        return indicador;
    }
}
