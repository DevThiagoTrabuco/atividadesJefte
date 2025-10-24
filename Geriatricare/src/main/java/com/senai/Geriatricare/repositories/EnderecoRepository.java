package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.EnderecoModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer> {
    EnderecoModel findByCliente(ClienteModelModel cliente);
    EnderecoModel findByClienteAndFamiliar(ClienteModelModel cliente, FamiliarModel familiar);
    EnderecoModel findByClienteAndFuncionario(ClienteModelModel cliente, FuncionarioModel funcionario);
    List<EnderecoModel> findByUnidadeFederativa(UnidadeFederativa unidadeFederativa);
    List<EnderecoModel> findByCidade(String cidade);
}
