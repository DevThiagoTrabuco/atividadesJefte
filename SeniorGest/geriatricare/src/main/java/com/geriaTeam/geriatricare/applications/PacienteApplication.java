package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.domain.Paciente;

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

    public void adicionar(Paciente paciente){
        this.pacienteRepository.adicionar(paciente);
    }

    public void atualizar(int codigo, Paciente paciente){
        this.pacienteRepository.atualizar(codigo, paciente);
    }

    public void remover(int codigo){
        this.pacienteRepository.remover(codigo);
    }

    public List<Paciente> buscar(){
        return this.pacienteRepository.buscar();
    }

    public Paciente buscarPorCodigo(int codigo){
        return this.pacienteRepository.buscarPorCodigo(codigo);
    }
}

