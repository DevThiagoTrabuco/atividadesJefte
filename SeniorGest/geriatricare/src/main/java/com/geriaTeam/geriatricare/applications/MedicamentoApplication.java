package com.geriaTeam.geriatricare.applications;


import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoApplication {
    private MedicamentoRepository medicamentoRepository;


    @Autowired
    public MedicamentoApplication(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public void adicionar(MedicamentoModels medicamentoModels){
        this.medicamentoRepository.adicionar(medicamentoModels);
    }

    public void atualizar(MedicamentoModels medicamentoModels){
        this.medicamentoRepository.atualizar(medicamentoModels);
    }

    public void remover(int codigo){
        this.medicamentoRepository.remover(codigo);
    }

    public List<MedicamentoModels> buscar(){
        return this.medicamentoRepository.buscar();
    }

    public MedicamentoModels buscarPorCodigo(int codigo){
        return this.medicamentoRepository.buscarPorCodigo(codigo);
    }
}
