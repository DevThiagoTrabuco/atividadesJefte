package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.models.domain.Medicamentos;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MedicamentosFacade {
    @Autowired
    private MedicamentosApplication medicamentosApplication;

    public List<Medicamentos> buscar() {
        return medicamentosApplication.buscar();
    }

    public Medicamentos buscarPorCodigo(UUID codigo) {
        return medicamentosApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Medicamentos medicamentos) {
        medicamentosApplication.cadastrar(medicamentos);
    }

    public void atualizar(UUID codigo, Medicamentos medicamentos) {
        medicamentosApplication.atualizar(codigo, medicamentos);
    }

    public void remover(UUID codigo, Medicamentos medicamentos) {
        medicamentosApplication.remover(codigo, medicamentos);
    }
}
