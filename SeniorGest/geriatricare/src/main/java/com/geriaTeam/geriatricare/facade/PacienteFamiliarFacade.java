package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PacienteFamiliarApplication;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteFamiliarFacade {
    @Autowired
    private PacienteFamiliarApplication pacienteFamiliarApplication;

    // Funções já existentes
    public List<PacienteFamiliarModels> buscar() {
        return pacienteFamiliarApplication.buscar();
    }

    public PacienteFamiliarModels buscarPorCodigo(int codigo) {
        return pacienteFamiliarApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarApplication.adicionar(pacienteFamiliarModels);
    }

    public void atualizar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarApplication.atualizar(pacienteFamiliarModels);
    }

    public void remover(int codigo) {
        pacienteFamiliarApplication.remover(codigo);
    }

    // Novas funções a serem adicionadas
    public void adicionarFamiliar(int pacienteId, int familiarId) {
        pacienteFamiliarApplication.adicionarFamiliar(pacienteId, familiarId);
    }

    public void removerFamiliar(int pacienteId, int familiarId) {
        pacienteFamiliarApplication.removerFamiliar(pacienteId, familiarId);
    }

    public PacienteFamiliarModels buscarRelacionamento(int pacienteId, int familiarId) {
        return pacienteFamiliarApplication.buscarRelacionamento(pacienteId, familiarId);
    }

    public void atualizarFamiliar(int pacienteId, int familiarId, int novoFamiliarId) {
        pacienteFamiliarApplication.atualizarFamiliar(pacienteId, familiarId, novoFamiliarId);
    }

    public boolean verificarFamiliar(int pacienteId, int familiarId) {
        return pacienteFamiliarApplication.verificarFamiliar(pacienteId, familiarId);
    }
}
