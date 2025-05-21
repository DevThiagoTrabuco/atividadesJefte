package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.MedicamentoApplication;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MedicamentoFacade {
    @Autowired
    private MedicamentoApplication medicamentoApplication;

    public List<MedicamentoModels> buscar() {
        return medicamentoApplication.buscar();
    }

    public MedicamentoModels buscarPorCodigo(int codigo) {
        return medicamentoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(MedicamentoModels medicamentoModels) {
        medicamentoApplication.adicionar(medicamentoModels);
    }

    public void atualizar(MedicamentoModels medicamentoModels) {
        medicamentoApplication.atualizar(medicamentoModels);
    }

    public void remover(int codigo) {
        medicamentoApplication.remover(codigo);
    }
}
