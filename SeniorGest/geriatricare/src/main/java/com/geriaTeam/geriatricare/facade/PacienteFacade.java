package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Paciente buscarPorCodigo(UUID codigo) {
        return pacienteApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Paciente paciente) {
        pacienteApplication.cadastrar(paciente);
    }

    public void atualizar(UUID codigo, Paciente paciente) {
        pacienteApplication.atualizar(codigo, paciente);
    }

    public void remover(UUID codigo, Paciente paciente) {
        pacienteApplication.remover(codigo, paciente);
    }
}
