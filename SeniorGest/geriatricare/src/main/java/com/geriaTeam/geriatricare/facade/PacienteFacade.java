package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.PacienteApplication;
import com.geriaTeam.geriatricare.models.PacienteModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PacienteFacade {
    @Autowired
    private PacienteApplication pacienteApplication;

    public List<PacienteModels> buscar() {
        return pacienteApplication.buscar();
    }

    public PacienteModels buscarPorCodigo(int codigo) {
        return pacienteApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteModels pacienteModels) {
        pacienteApplication.adicionar(pacienteModels);
    }

    public void atualizar(PacienteModels pacienteModels) {
        pacienteApplication.atualizar(pacienteModels);
    }

    public void remover(int codigo) {
        pacienteApplication.remover(codigo);
    }
}

