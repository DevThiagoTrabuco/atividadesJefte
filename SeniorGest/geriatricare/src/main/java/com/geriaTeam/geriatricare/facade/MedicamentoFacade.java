package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.MedicamentoApplication;
import com.geriaTeam.geriatricare.models.domain.Medicamento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MedicamentoFacade {
    @Autowired
    private MedicamentoApplication medicamentoApplication;

    public List<Medicamento> buscar() {
        return medicamentoApplication.buscar();
    }

    public Medicamento buscarPorCodigo(int codigo) {
        return medicamentoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Medicamento medicamento) {
        medicamentoApplication.adicionar(medicamento);
    }

    public void atualizar(int codigo, Medicamento medicamento) {
        medicamentoApplication.atualizar(codigo, medicamento);
    }

    public void remover(int codigo) {
        medicamentoApplication.remover(codigo);
    }
}
