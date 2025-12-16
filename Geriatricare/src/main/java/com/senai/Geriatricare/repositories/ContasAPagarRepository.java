package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.enums.TipoConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Integer> {
    List<ContasAPagarModel> findByClienteAndCNPJ(ClienteModel cliente, String cnpj);
    List<ContasAPagarModel> findByCliente(ClienteModel cliente);
    List<ContasAPagarModel> findByClienteAndTipoConta(ClienteModel cliente, TipoConta tipoConta);
    List<ContasAPagarModel> findByClienteAndChaveNFE(ClienteModel cliente, String chaveNFE);
    List<ContasAPagarModel> findByClienteAndStatusConta(ClienteModel cliente, StatusConta statusConta);
    List<ContasAPagarModel> findByClienteAndPacienteIdAndStatusConta(ClienteModel cliente, Integer pacienteId, StatusConta status);
    List<ContasAPagarModel> findByClienteAndPacienteId(ClienteModel cliente, Integer pacienteId);
    List<ContasAPagarModel> findByClienteAndPacienteIsNullAndStatusConta(ClienteModel cliente, StatusConta status);
    List<ContasAPagarModel> findByClienteAndPacienteIsNull(ClienteModel cliente);
}
