package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.PacienteApplication;
import com.geriaTeam.geriatricare.models.domain.Paciente;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PacienteFacade {
    @Autowired
    private PacienteApplication pacienteApplication;

    public List<Paciente> buscar() {
        return pacienteApplication.buscar();
    }

    public Paciente buscarPorCodigo(int codigo) {
        return pacienteApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Paciente paciente) {
        pacienteApplication.adicionar(paciente);
    }

    public void atualizar(int codigo, Paciente paciente) {
        pacienteApplication.atualizar(codigo, paciente);
    }

    public void remover(int codigo) {
        pacienteApplication.remover(codigo);
    }
}

