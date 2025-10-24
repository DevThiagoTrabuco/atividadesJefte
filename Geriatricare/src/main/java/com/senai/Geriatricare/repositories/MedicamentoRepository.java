package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Integer> {
    List<MedicamentoModel> findByClienteAndNomeGenerico(ClienteModelModel cliente, String nomeGenerico);
    List<MedicamentoModel> findByClienteAndNomeComercial(ClienteModelModel cliente, String nomeComercial);
    List<MedicamentoModel> findByClienteAndDataValidade(ClienteModelModel cliente, LocalDate dataValidade);
}
