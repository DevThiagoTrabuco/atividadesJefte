package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PacienteMedicamentoRepository;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.repositories.jpa.PacienteMedicamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteMedicamentoRepositoryMySqQLImpl implements PacienteMedicamentoRepository {
    private final PacienteMedicamentoJPA pacienteMedicamentoJPA;

    @Autowired

    public PacienteMedicamentoRepositoryMySqQLImpl(PacienteMedicamentoJPA pacienteMedicamentoJPA) {
        this.pacienteMedicamentoJPA = pacienteMedicamentoJPA;
    }

    @Override
    public PacienteMedicamentoModels buscarPorCodigo(int codigo) {
        return this.pacienteMedicamentoJPA.findById(codigo).get();
    }

    @Override
    public List<PacienteMedicamentoModels> buscar() {
        return this.pacienteMedicamentoJPA.findAll();
    }

    @Override
    public void adicionar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        this.pacienteMedicamentoJPA.save(pacienteMedicamentoModels);
    }

    @Override
    public void remover(int codigo) {
        this.pacienteMedicamentoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        this.pacienteMedicamentoJPA.save(pacienteMedicamentoModels);
    }


}
