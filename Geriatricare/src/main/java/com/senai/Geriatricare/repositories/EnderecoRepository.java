package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.EnderecoModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer> {
    EnderecoModel findByCliente(ClienteModel cliente);
    EnderecoModel findByClienteAndFamiliar(ClienteModel cliente, FamiliarModel familiar);
    EnderecoModel findByClienteAndFuncionario(ClienteModel cliente, FuncionarioModel funcionario);
    List<EnderecoModel> findByUnidadeFederativa(UnidadeFederativa unidadeFederativa);
    List<EnderecoModel> findByCidade(String cidade);
}
