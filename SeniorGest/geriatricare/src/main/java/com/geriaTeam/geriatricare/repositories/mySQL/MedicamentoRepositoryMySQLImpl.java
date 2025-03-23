package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamento;
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
    public Medicamento buscarPorCodigo(int codigo) {
        return this.medicamentoJPA.findById(codigo).get();
    }

    @Override
    public List<Medicamento> buscar() {
        return this.medicamentoJPA.findAll();
    }

    @Override
    public void adicionar(Medicamento medicamento) {
        this.medicamentoJPA.save(medicamento);
    }

    @Override
    public void remover(int codigo) {
        this.medicamentoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Medicamento medicamento) {
        Medicamento medicamentoDb = this.medicamentoJPA.findById(codigo).get();

        medicamentoDb.setNome(medicamento.getNome());
        medicamentoDb.setQtd(medicamento.getQtd());
        medicamentoDb.setLote(medicamento.getLote());
        medicamentoDb.setVencimento(medicamento.getVencimento());

        this.medicamentoJPA.save(medicamentoDb);
    }
}
