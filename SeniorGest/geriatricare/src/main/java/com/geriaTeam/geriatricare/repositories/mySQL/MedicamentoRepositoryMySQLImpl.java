package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import com.geriaTeam.geriatricare.repositories.jpa.MedicamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicamentoRepositoryMySQLImpl implements MedicamentoRepository {
    private final MedicamentoJPA medicamentoJPA;

    @Autowired
    public MedicamentoRepositoryMySQLImpl(MedicamentoJPA medicamentoJPA) {
        this.medicamentoJPA = medicamentoJPA;
    }

    @Override
    public MedicamentoModels buscarPorCodigo(int codigo) {
        return this.medicamentoJPA.findById(codigo).get();
    }

    @Override
    public List<MedicamentoModels> buscar() {
        return this.medicamentoJPA.findAll();
    }

    @Override
    public void adicionar(MedicamentoModels medicamentoModels) {
        this.medicamentoJPA.save(medicamentoModels);
    }

    @Override
    public void remover(int codigo) {
        this.medicamentoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(MedicamentoModels medicamentoModels) {
        this.medicamentoJPA.save(medicamentoModels);
    }
}
