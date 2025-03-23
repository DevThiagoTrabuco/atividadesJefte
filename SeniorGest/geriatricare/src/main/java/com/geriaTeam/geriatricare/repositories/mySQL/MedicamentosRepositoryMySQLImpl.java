package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.MedicamentosRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import com.geriaTeam.geriatricare.repositories.jpa.MedicamentosJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicamentosRepositoryMySQLImpl implements MedicamentosRepository {
    private final MedicamentosJPA medicamentosJPA;

    @Autowired
    public MedicamentosRepositoryMySQLImpl(MedicamentosJPA medicamentosJPA) {
        this.medicamentosJPA = medicamentosJPA;
    }

    @Override
    public Medicamentos buscarPorCodigo(int codigo) {
        return this.medicamentosJPA.findById(codigo).get();
    }

    @Override
    public List<Medicamentos> buscar() {
        return this.medicamentosJPA.findAll();
    }

    @Override
    public void adicionar(Medicamentos medicamentos) {
        this.medicamentosJPA.save(medicamentos);
    }

    @Override
    public void remover(int codigo) {
        this.medicamentosJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Medicamentos medicamentos) {
        Medicamentos medicamentosDb = this.medicamentosJPA.findById(codigo).get();

        medicamentosDb.setNome(medicamentos.getNome());
        medicamentosDb.setQtdMedicamentos(medicamentos.getQtdMedicamentos());

        this.medicamentosJPA.save(medicamentosDb);
    }
}
