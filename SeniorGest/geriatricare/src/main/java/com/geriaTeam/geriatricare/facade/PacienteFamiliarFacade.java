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

    public List<PacienteFamiliarModels> buscarTodosPacienteFamiliar() {
        return pacienteFamiliarApplication.buscarTodosPacienteFamiliar();
    }
}
