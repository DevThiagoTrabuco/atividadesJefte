package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.MedicamentosApplication;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MedicamentosFacade {
    @Autowired
    private MedicamentosApplication medicamentosApplication;

    public List<Medicamentos> buscar() {
        return medicamentosApplication.buscar();
    }

    public Medicamentos buscarPorCodigo(int codigo) {
        return medicamentosApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Medicamentos medicamentos) {
        medicamentosApplication.adicionar(medicamentos);
    }

    public void atualizar(int codigo, Medicamentos medicamentos) {
        medicamentosApplication.atualizar(codigo, medicamentos);
    }

    public void remover(int codigo) {
        medicamentosApplication.remover(codigo);
    }
}
