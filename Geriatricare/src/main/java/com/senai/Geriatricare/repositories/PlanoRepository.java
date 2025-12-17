package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.TipoPlano;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, Integer> {
    List<PlanoModel> findByClienteAndTipo(ClienteModel cliente, TipoPlano tipoPlano);
    Optional<PlanoModel> findByIdAndCliente(Integer id, ClienteModel cliente);
    List<PlanoModel> findByCliente(ClienteModel cliente);
}
