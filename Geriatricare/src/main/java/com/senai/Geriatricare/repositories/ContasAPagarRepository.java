package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.TipoConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Integer> {

    @Query("SELECT c FROM ContasAPagarModel c WHERE c.cliente.cnpj = :cnpj")
    List<ContasAPagarModel> findByClienteAndCnpj(@Param("cnpj") String cnpj);

    List<ContasAPagarModel> findByCliente(ClienteModel cliente);

    List<ContasAPagarModel> findByClienteAndTipoConta(ClienteModel cliente, TipoConta tipoConta);

    List<ContasAPagarModel> findByClienteAndChaveNFE(ClienteModel cliente, String chaveNFE);
}
