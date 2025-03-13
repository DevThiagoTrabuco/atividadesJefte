package com.geriaTeam.geriatricare.applications;


import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import com.geriaTeam.geriatricare.repositories.MedicamentosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentosApplication {
    private MedicamentosRepositoryImpl medicamentosRepository;


    @Autowired
    public MedicamentosApplication(MedicamentosRepositoryImpl medicamentosRepository) {
        this.medicamentosRepository = medicamentosRepository;
    }

    public void adicionar(Medicamentos medicamentos){
        this.medicamentosRepository.adicionar(medicamentos);
    }

    public void atualizar(int code, Medicamentos medicamentos){
        this.medicamentosRepository.atualizar(code, medicamentos);
    }

    public void remover(int code){
        this.medicamentosRepository.remover(code);
    }

    public List<Medicamentos> buscar(){
        return this.medicamentosRepository.buscar();
    }

    public Medicamentos buscarPorCodigo(int code){
        return this.medicamentosRepository.buscarPorCodigo(code);
    }
}
