package com.geriaTeam.geriatricare.applications;


import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamento;
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

    public void adicionar(Medicamento medicamento){
        this.medicamentoRepository.adicionar(medicamento);
    }

    public void atualizar(int code, Medicamento medicamento){
        this.medicamentoRepository.atualizar(code, medicamento);
    }

    public void remover(int code){
        this.medicamentoRepository.remover(code);
    }

    public List<Medicamento> buscar(){
        return this.medicamentoRepository.buscar();
    }

    public Medicamento buscarPorCodigo(int code){
        return this.medicamentoRepository.buscarPorCodigo(code);
    }
}
