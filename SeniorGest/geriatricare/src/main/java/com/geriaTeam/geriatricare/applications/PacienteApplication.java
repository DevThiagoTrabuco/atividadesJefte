package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.PacienteModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteApplication {
    private PacienteRepository pacienteRepository;


    @Autowired
    public PacienteApplication(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void adicionar(PacienteModels pacienteModels){
        this.pacienteRepository.adicionar(pacienteModels);
    }

    public void atualizar(PacienteModels pacienteModels){
        this.pacienteRepository.atualizar(pacienteModels);
    }

    public void remover(int codigo){
        this.pacienteRepository.remover(codigo);
    }

    public List<PacienteModels> buscar(){
        return this.pacienteRepository.buscar();
    }

    public PacienteModels buscarPorCodigo(int codigo){
        return this.pacienteRepository.buscarPorCodigo(codigo);
    }
}

