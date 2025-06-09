package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import com.geriaTeam.geriatricare.repositories.jpa.MedicamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicamentoRepositoryMySQLImpl implements MedicamentoRepository {

    @Autowired
    private MedicamentoJPA medicamentoJPA;

    @Override
    public MedicamentoModels buscarMedicamentoId(int codigo) {
        return this.medicamentoJPA.findById(codigo).get();
    }

    @Override
    public List<MedicamentoModels> buscarMedicamento() {
        return this.medicamentoJPA.findAll();
    }

    @Override
    public void adicionarMedicamento(MedicamentoModels medicamentoModels) {
        this.medicamentoJPA.save(medicamentoModels);
    }

    @Override
    public void removerMedicamento(int codigo) {
        this.medicamentoJPA.deleteById(codigo);
    }

    @Override
    public void atualizarMedicamento(MedicamentoModels medicamentoModels) {
        this.medicamentoJPA.save(medicamentoModels);
    }
}
