package com.geriaTeam.geriatricare.applications;


import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import com.geriaTeam.geriatricare.repositories.MedicamentosRepositoryImpl;
import com.geriaTeam.geriatricare.services.MedicamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentosApplication {
    private MedicamentosRepositoryImpl medicamentosRepository;
    private MedicamentosService medicamentosService;

    @Autowired
    public MedicamentosApplication(MedicamentosRepositoryImpl medicamentosRepository) {
        this.medicamentosRepository = medicamentosRepository;
    }

    public void registrar(Medicamentos medicamentos){
        this.medicamentosService.registrarMedicamento(medicamentos);
    }

    public void atualizar(int id, Medicamentos medicamentos){
        this.medicamentosService.atualizarMedicamento(id, medicamentos);
    }

    public void remover(int id){
        this.medicamentosService.excluirMedicamento(id);
    }

    public List<Medicamentos> listar(){
        return this.medicamentosService.listarTodos();
    }

    public Medicamentos listarPorCodigo(int id){
        return this.medicamentosService.listarPorCodigo(id);
    }
    public void reduzirEstoque(int id, int quantidade) {
        this.medicamentosService.reduzirEstoque(id, quantidade);
    }
    public void reabastecerEstoque(int id, int quantidade) {
        this.medicamentosService.reabastecerEstoque(id, quantidade);
    }
    private boolean medicamentoVinculadoAPaciente(int id) {
        return false;
    }
}
