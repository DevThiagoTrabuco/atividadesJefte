package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Integer> {
    List<MedicamentoEntity> findByNomeGenerico(int clienteId, String nomeGenerico);
    List<MedicamentoEntity> findByNomeComercial(int clienteId, String nomeComercial);
    List<MedicamentoEntity> findByDataValidade(int clienteId, String dataValidade);
    List<MedicamentoEntity> findByStatusMedicamento (int clienteId, String statusMedicamento);
}
