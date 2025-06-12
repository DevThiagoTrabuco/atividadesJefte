package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Integer> {
    List<MedicamentoEntity> findByClienteAndNomeGenerico(ClienteEntity cliente, String nomeGenerico);
    List<MedicamentoEntity> findByClienteAndNomeComercial(ClienteEntity cliente, String nomeComercial);
    List<MedicamentoEntity> findByClienteAndDataValidade(ClienteEntity cliente, LocalDate dataValidade);
    List<MedicamentoEntity> findByClienteAndStatusMedicamento(ClienteEntity cliente, String statusMedicamento);
}
