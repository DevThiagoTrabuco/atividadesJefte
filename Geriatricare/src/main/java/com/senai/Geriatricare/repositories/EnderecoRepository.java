package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.EnderecoEntity;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    EnderecoEntity findByCliente(ClienteEntity cliente);
    EnderecoEntity findByClienteAndFamiliar(ClienteEntity cliente, FamiliarEntity familiar);
    EnderecoEntity findByClienteAndFuncionario(ClienteEntity cliente, FuncionarioEntity funcionario);
    List<EnderecoEntity> findByUnidadeFederativa(UnidadeFederativa unidadeFederativa);
    List<EnderecoEntity> findByCidade(String cidade);
}
