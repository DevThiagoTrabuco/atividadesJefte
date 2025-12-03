package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Integer> {
    List<MedicamentoModel> findByClienteAndNomeGenerico(ClienteModel cliente, String nomeGenerico);
    List<MedicamentoModel> findByClienteAndNomeComercial(ClienteModel cliente, String nomeComercial);
    List<MedicamentoModel> findByClienteAndDataValidade(ClienteModel cliente, LocalDate dataValidade);
}
